package discojx.discogs.api.user.identity.requests.profile;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsEndpoints;
import discojx.discogs.objects.Profile;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultAsyncProfileRequest implements AsyncProfileRequest {

    protected final AbstractHttpClient<HttpEntity> client;

    protected static final ObjectMapper jsonMapper = new JsonMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private final String username;

    public DefaultAsyncProfileRequest(Builder builder) {
        this.client = builder.client;
        this.username = builder.username;
    }

    public static class Builder implements AsyncProfileRequestBuilder {

        private final AbstractHttpClient<HttpEntity> client;

        private String username;

        public Builder(AbstractHttpClient<HttpEntity> client) {
            this.client = client;
        }

        @Override
        public AsyncProfileRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        @Override
        public AsyncProfileRequest build() {
            return new DefaultAsyncProfileRequest(this);
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
    public CompletableFuture<Profile> supplyFuture() {
        return CompletableFuture.supplyAsync(() -> {
            String endpoint = DiscogsEndpoints.USER_PROFILE.getEndpoint().replace("{username}", username);
            Optional<HttpEntity> execute = client.execute(new HttpGet(endpoint));
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            InputStream jsonResponse;
            try {
                jsonResponse = httpEntity.getContent();
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            Profile profile;
            try {
                profile = jsonMapper.readValue(jsonResponse, Profile.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return profile;
        });
    }

    @Override
    public String toString() {
        return "DefaultAsyncProfileRequest{" +
                "client=" + client +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultAsyncProfileRequest that = (DefaultAsyncProfileRequest) o;
        return Objects.equals(client, that.client) && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, username);
    }
}
