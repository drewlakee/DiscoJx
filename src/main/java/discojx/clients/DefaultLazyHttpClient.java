package discojx.clients;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.utils.json.JsonUtils;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletionException;

public class DefaultLazyHttpClient extends AbstractHttpClient {

    protected String token;
    protected List<Header> customRequestHeaders;

    protected static class Holder {
        public static final CloseableHttpClient client = HttpClients.createDefault();
    }

    public DefaultLazyHttpClient() {
        this.customRequestHeaders = List.of(
                new BasicHeader("User-Agent", "discojx/1.0.0 An Asynchronous DiscogsAPI Java Client Library")
        );
    }

    public DefaultLazyHttpClient(String token) {
        this.token = token;
        this.customRequestHeaders = List.of(
                new BasicHeader("User-Agent", "discojx/1.0.0 An Asynchronous DiscogsAPI Java Client Library"),
                new BasicHeader("Authorization", "Discogs token=" + token)
        );
    }

    public DefaultLazyHttpClient(String token, List<Header> customRequestHeaders) {
        this.token = token;
        this.customRequestHeaders = customRequestHeaders;
    }

    public DefaultLazyHttpClient(List<Header> customRequestHeaders) {
        this.customRequestHeaders = customRequestHeaders;
    }

    @Override
    public HttpResponse execute(HttpUriRequest request) {
        for (Header header : customRequestHeaders) {
            request.addHeader(header);
        }

        try {
            CloseableHttpResponse response = Holder.client.execute(request);
            return validateAndGetOrThrowException(response);
        } catch (Exception e) {
            throw new CompletionException(request.toString(), e);
        }
    }

    protected HttpResponse validateAndGetOrThrowException(HttpResponse response) throws HttpException, IOException {
        if (response.getStatusLine().getStatusCode() > 299) {
            if (response.getEntity() != null && response.containsHeader("Content-Type")
                                             && response.getFirstHeader("Content-Type").getValue().equals("application/json")) {
                JsonNode jsonNode = JsonUtils.DefaultObjectMapperHolder.mapper.readTree(response.getEntity().getContent());

                throw new HttpException(response.getStatusLine().toString() + " " + jsonNode.toString());
            }

            throw new HttpException(response.getStatusLine().toString());
        }

        return response;
    }

    @Override
    public String toString() {
        return "DefaultLazyHttpClient{" +
                "customRequestHeaders=" + customRequestHeaders +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultLazyHttpClient client = (DefaultLazyHttpClient) o;
        return Objects.equals(token, client.token) && Objects.equals(customRequestHeaders, client.customRequestHeaders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, customRequestHeaders);
    }
}
