package discojx.clients;

import discojx.clients.authentication.PersonalAccessToken;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletionException;

public class PersonalAccessTokenLazyHttpClient extends AbstractHttpClient<HttpEntity> {

    private final PersonalAccessToken token;

    public PersonalAccessTokenLazyHttpClient(PersonalAccessToken token) {
        this.token = token;
    }

    private static class Holder {
        public static final CloseableHttpClient client = HttpClients.createDefault();
    }

    @Override
    public Optional<HttpEntity> execute(HttpUriRequest request) {
        request.addHeader("Authorization", "Discogs token=" + token);
        request.addHeader("User-Agent", "discojx/1.0.0 An Asynchronous DiscogsAPI Client Library");

        try {
            CloseableHttpResponse response = Holder.client.execute(request);
            return validateAndGetOrThrowException(response);
        } catch (Exception e) {
            throw new CompletionException(request.toString(), e);
        }
    }

    public Optional<HttpEntity> validateAndGetOrThrowException(CloseableHttpResponse response) throws HttpException {
        if (response.getStatusLine().getStatusCode() > 299) {
            throw new HttpException(response.getStatusLine().toString());
        }

        return Optional.of(response.getEntity());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalAccessTokenLazyHttpClient that = (PersonalAccessTokenLazyHttpClient) o;
        return Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token);
    }
}
