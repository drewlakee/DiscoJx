package discojx.clients;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import discojx.clients.authentication.PersonalAccessToken;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletionException;

public class DefaultLazyHttpClient extends AbstractHttpClient<HttpEntity> {

    private PersonalAccessToken token;
    private List<Header> headers;

    protected static final ObjectMapper jsonMapper = new JsonMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private static class Holder {
        public static final CloseableHttpClient client = HttpClients.createDefault();
    }

    public DefaultLazyHttpClient() {
        this.headers = List.of(
                new BasicHeader("User-Agent", "discojx/1.0.0 An Asynchronous DiscogsAPI Client Library")
        );
    }

    public DefaultLazyHttpClient(PersonalAccessToken token) {
        this.token = token;
        this.headers = List.of(
                new BasicHeader("User-Agent", "discojx/1.0.0 An Asynchronous DiscogsAPI Client Library"),
                new BasicHeader("Authorization", "Discogs token=" + token)
        );
    }

    public DefaultLazyHttpClient setHeaders(List<Header> headers) {
        if (headers != null) {
            this.headers = headers;
        }

        return this;
    }

    public List<Header> getHeaders() {
        return headers;
    }

    @Override
    public Optional<HttpEntity> execute(HttpUriRequest request) {
        for (Header header : headers) {
            request.addHeader(header);
        }

        try {
            CloseableHttpResponse response = Holder.client.execute(request);
            return validateAndGetOrThrowException(response);
        } catch (Exception e) {
            throw new CompletionException(request.toString(), e);
        }
    }

    public Optional<HttpEntity> validateAndGetOrThrowException(CloseableHttpResponse response) throws HttpException, IOException {
        if (response.getStatusLine().getStatusCode() > 299) {
            if (response.getEntity() != null && response.containsHeader("Content-Type")
                                             && response.getHeaders("Content-Type")[0].getValue().equals("application/json")) {
                JsonNode jsonNode = jsonMapper.readTree(response.getEntity().getContent());

                throw new HttpException(response.getStatusLine().toString() + " " + jsonNode.toString());
            }

            throw new HttpException(response.getStatusLine().toString());
        }

        return Optional.ofNullable(response.getEntity());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultLazyHttpClient client = (DefaultLazyHttpClient) o;
        return Objects.equals(token, client.token) && Objects.equals(headers, client.headers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, headers);
    }
}
