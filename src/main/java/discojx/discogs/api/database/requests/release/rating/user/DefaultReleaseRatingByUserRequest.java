package discojx.discogs.api.database.requests.release.rating.user;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsEndpoints;
import discojx.discogs.objects.ReleaseRating;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultReleaseRatingByUserRequest implements ReleaseRatingByUserRequest {

    protected final AbstractHttpClient<HttpEntity> client;

    protected static final ObjectMapper jsonMapper = new JsonMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private final long releaseId;
    private final String username;

    public DefaultReleaseRatingByUserRequest(Builder builder) {
        this.client = builder.client;
        this.releaseId = builder.releaseId;
        this.username = builder.username;
    }

    public static class Builder implements ReleaseRatingByUserRequestBuilder {

        private final AbstractHttpClient<HttpEntity> client;

        private long releaseId;
        private String username;

        public Builder(AbstractHttpClient<HttpEntity> client) {
            this.client = client;
        }

        @Override
        public ReleaseRatingByUserRequestBuilder releaseId(long releaseId) {
            this.releaseId = releaseId;
            return this;
        }

        @Override
        public ReleaseRatingByUserRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        @Override
        public ReleaseRatingByUserRequest build() {
            return new DefaultReleaseRatingByUserRequest(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "client=" + client +
                    ", releaseId=" + releaseId +
                    ", username='" + username + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return releaseId == builder.releaseId && Objects.equals(client, builder.client) && Objects.equals(username, builder.username);
        }

        @Override
        public int hashCode() {
            return Objects.hash(client, releaseId, username);
        }
    }

    @Override
    public CompletableFuture<ReleaseRating> supplyFuture() {
        return CompletableFuture.supplyAsync(() -> {
            String endpoint = DiscogsEndpoints.DATABASE_RELEASE_RATING_BY_USER.getEndpoint().replace("{release_id}", String.valueOf(releaseId)).replace("{username}", username);
            Optional<HttpEntity> execute = client.execute(new HttpGet(endpoint));
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            ReleaseRating releaseRating;
            try {
                releaseRating = jsonMapper.readValue(httpEntity.getContent(), ReleaseRating.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return releaseRating;
        });
    }

    @Override
    public String toString() {
        return "DefaultReleaseRatingByUserRequest{" +
                "client=" + client +
                ", releaseId=" + releaseId +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultReleaseRatingByUserRequest that = (DefaultReleaseRatingByUserRequest) o;
        return releaseId == that.releaseId && Objects.equals(client, that.client) && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, releaseId, username);
    }
}
