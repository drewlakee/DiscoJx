package discojx.discogs.api.database.requests.release.rating.user;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.ReleaseRating;
import discojx.requests.AbstractRequest;
import discojx.requests.AbstractRequestBuilder;
import discojx.utils.json.JsonUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultReleaseRatingByUserRequest extends AbstractRequest<HttpEntity>
        implements ReleaseRatingByUserRequest {

    public DefaultReleaseRatingByUserRequest(Builder builder) {
        super(builder);
    }

    public static class Builder extends AbstractRequestBuilder<HttpEntity>
            implements ReleaseRatingByUserRequestBuilder {

        private long releaseId;
        private String username;

        public Builder(AbstractHttpClient<HttpEntity> client) {
            super(client);
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
            this.queryUrl = DiscogsApiEndpoints
                    .DATABASE_RELEASE_RATING_BY_USER
                    .getEndpoint()
                    .replace("{release_id}", String.valueOf(releaseId))
                    .replace("{username}", username);
            return new DefaultReleaseRatingByUserRequest(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "client=" + client +
                    ", releaseId=" + releaseId +
                    ", username='" + username + '\'' +
                    ", queryUrl='" + queryUrl + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return releaseId == builder.releaseId && Objects.equals(client, builder.client) && Objects.equals(username, builder.username) && Objects.equals(queryUrl, builder.queryUrl);
        }

        @Override
        public int hashCode() {
            return Objects.hash(client, releaseId, username, queryUrl);
        }
    }

    @Override
    public CompletableFuture<ReleaseRating> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            Optional<HttpEntity> execute = client.execute(new HttpGet(queryUrl));
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            ReleaseRating releaseRating;
            try {
                releaseRating = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(httpEntity.getContent(), ReleaseRating.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return releaseRating;
        });
    }
}
