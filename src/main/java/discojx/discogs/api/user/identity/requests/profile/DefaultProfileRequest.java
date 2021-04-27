package discojx.discogs.api.user.identity.requests.profile;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.Profile;
import discojx.utils.json.JsonUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultProfileRequest implements ProfileRequest {

    protected final AbstractHttpClient<HttpEntity> client;

    private final String queryUrl;

    public DefaultProfileRequest(Builder builder) {
        this.client = builder.client;
        this.queryUrl = builder.queryUrl;
    }

    public static class Builder implements ProfileRequestBuilder {

        private final AbstractHttpClient<HttpEntity> client;

        private String username;

        private String queryUrl;

        public Builder(AbstractHttpClient<HttpEntity> client) {
            this.client = client;
        }

        @Override
        public ProfileRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        @Override
        public ProfileRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .USER_PROFILE
                    .getEndpoint()
                    .replace("{username}", username);
            return new DefaultProfileRequest(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "client=" + client +
                    ", username='" + username + '\'' +
                    ", queryUrl='" + queryUrl + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return Objects.equals(client, builder.client) && Objects.equals(username, builder.username) && Objects.equals(queryUrl, builder.queryUrl);
        }

        @Override
        public int hashCode() {
            return Objects.hash(client, username, queryUrl);
        }
    }

    @Override
    public CompletableFuture<Profile> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            Optional<HttpEntity> execute = client.execute(new HttpGet(queryUrl));
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            Profile profile;
            try {
                profile = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(httpEntity.getContent(), Profile.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return profile;
        });
    }

    @Override
    public String toString() {
        return "DefaultProfileRequest{" +
                "client=" + client +
                ", queryUrl='" + queryUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultProfileRequest that = (DefaultProfileRequest) o;
        return Objects.equals(client, that.client) && Objects.equals(queryUrl, that.queryUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, queryUrl);
    }
}
