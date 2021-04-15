package discojx.clients;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletionException;

public class PersonalAccessTokenLazyHttpClient extends AbstractHttpClient<HttpEntity> {

    private final String token;

    public PersonalAccessTokenLazyHttpClient(String token) {
        this.token = token;
    }

    private static class Holder {
        public static final CloseableHttpClient client = HttpClients.createDefault();
    }

    @Override
    public Optional<HttpEntity> execute(HttpUriRequest request) {
        request.addHeader("Authorization", "Discogs token=" + token);

        try {
            CloseableHttpResponse execute = Holder.client.execute(request);
            return Optional.of(execute.getEntity());
        } catch (IOException e) {
            throw new CompletionException(e);
        }
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
