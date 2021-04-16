package discojx.discogs.api.user.identity.requests.submissions;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsEndpoints;
import discojx.discogs.objects.Submissions;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultAsyncUserSubmissionsRequest implements AsyncUserSubmissionsRequest {

    protected final AbstractHttpClient<HttpEntity> client;

    protected static final ObjectMapper jsonMapper = new JsonMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private final String username;

    public DefaultAsyncUserSubmissionsRequest(Builder builder) {
        this.client = builder.client;
        this.username = builder.username;
    }

    public static class Builder implements AsyncUserSubmissionsRequestBuilder {

        private final AbstractHttpClient<HttpEntity> client;

        private String username;

        public Builder(AbstractHttpClient<HttpEntity> client) {
            this.client = client;
        }

        @Override
        public AsyncUserSubmissionsRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        @Override
        public AsyncUserSubmissionsRequest build() {
            return new DefaultAsyncUserSubmissionsRequest(this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return Objects.equals(client, builder.client) && Objects.equals(username, builder.username);
        }

        @Override
        public int hashCode() {
            return Objects.hash(client, username);
        }
    }

    @Override
    public CompletableFuture<Submissions> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            Optional<HttpEntity> execute = client.execute(new HttpGet(DiscogsEndpoints.USER_SUBMISSIONS.getEndpoint().replace("{username}", username)));
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            Submissions submissions;
            try {
                submissions = jsonMapper.readValue(httpEntity.getContent(), Submissions.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return submissions;
        });
    }

    @Override
    public String toString() {
        return "DefaultAsyncUserSubmissionsRequest{" +
                "client=" + client +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultAsyncUserSubmissionsRequest that = (DefaultAsyncUserSubmissionsRequest) o;
        return Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client);
    }
}
