package discojx.discogs.api.database.requests.release.rating.user.delete;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpDelete;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class DefaultReleaseRatingDeleteByUserRequest implements ReleaseRatingDeleteByUserRequest {

    protected final AbstractHttpClient<HttpEntity> client;

    private final long releaseId;
    private final String username;

    public DefaultReleaseRatingDeleteByUserRequest(Builder builder) {
        this.client = builder.client;
        this.releaseId = builder.releaseId;
        this.username = builder.username;
    }

    public static class Builder implements ReleaseRatingDeleteByUserRequestBuilder {

        private final AbstractHttpClient<HttpEntity> client;

        private long releaseId;
        private String username;

        public Builder(AbstractHttpClient<HttpEntity> client) {
            this.client = client;
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
            return new DefaultReleaseRatingDeleteByUserRequest(this);
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
    public CompletableFuture<Void> supplyFuture() {
        return CompletableFuture.runAsync(() -> {
            String endpoint = DiscogsApiEndpoints.DATABASE_RELEASE_RATING_BY_USER.getEndpoint().replace("{release_id}", String.valueOf(releaseId)).replace("{username}", username);
            client.execute(new HttpDelete(endpoint));
        });
    }


    @Override
    public String toString() {
        return "DefaultReleaseRatingDeleteByUserRequest{" +
                "client=" + client +
                ", releaseId=" + releaseId +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultReleaseRatingDeleteByUserRequest that = (DefaultReleaseRatingDeleteByUserRequest) o;
        return releaseId == that.releaseId && Objects.equals(client, that.client) && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, releaseId, username);
    }
}
