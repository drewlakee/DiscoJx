package discojx.discogs.api.database.requests.release.rating.user.delete;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.requests.AbstractRequest;
import discojx.requests.AbstractRequestBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class DefaultReleaseRatingDeleteByUserRequest extends AbstractRequest
        implements ReleaseRatingDeleteByUserRequest {

    public DefaultReleaseRatingDeleteByUserRequest(Builder builder) {
        super(builder);
    }

    public static class Builder extends AbstractRequestBuilder
            implements ReleaseRatingDeleteByUserRequestBuilder {

        private long releaseId;
        private String username;

        public Builder(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public ReleaseRatingDeleteByUserRequestBuilder releaseId(long releaseId) {
            this.releaseId = releaseId;
            return this;
        }

        @Override
        public ReleaseRatingDeleteByUserRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        @Override
        public DefaultReleaseRatingDeleteByUserRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .DATABASE_RELEASE_RATING_BY_USER
                    .getEndpoint()
                    .replace("{release_id}", String.valueOf(releaseId))
                    .replace("{username}", username);
            return new DefaultReleaseRatingDeleteByUserRequest(this);
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
    public CompletableFuture<HttpResponse> executeAsync() {
        return CompletableFuture.supplyAsync(() -> client.execute(new HttpDelete(queryUrl)));
    }
}
