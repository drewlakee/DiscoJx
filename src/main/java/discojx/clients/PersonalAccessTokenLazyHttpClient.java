package discojx.clients;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Optional;

public class PersonalAccessTokenLazyHttpClient extends AbstractHttpClient<HttpEntity> {

    private final byte[] tokenBytes;

    public PersonalAccessTokenLazyHttpClient(String token) {
        this.tokenBytes = token.getBytes(StandardCharsets.UTF_8);
    }

    private static class Holder {
        public static final CloseableHttpClient client = HttpClients.createDefault();
    }

    @Override
    protected Optional<HttpEntity> execute(HttpUriRequest request) {
        request.addHeader("Authorization", "Discogs token=" + Arrays.toString(tokenBytes));

        try {
            CloseableHttpResponse execute = Holder.client.execute(request);
            return Optional.of(execute.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalAccessTokenLazyHttpClient that = (PersonalAccessTokenLazyHttpClient) o;
        return Arrays.equals(tokenBytes, that.tokenBytes);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(tokenBytes);
    }
}
