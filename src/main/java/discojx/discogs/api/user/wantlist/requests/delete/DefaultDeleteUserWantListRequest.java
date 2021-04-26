package discojx.discogs.api.user.wantlist.requests.delete;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpDelete;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class DefaultDeleteUserWantListRequest implements DeleteUserWantListRequest {

    protected final AbstractHttpClient<HttpEntity> client;

    protected final String queryUrl;

    public DefaultDeleteUserWantListRequest(Builder builder) {
        this.client = builder.client;
        this.queryUrl = builder.queryUrl;
    }

    public static class Builder implements DeleteUserWantListRequestBuilder {

        private final AbstractHttpClient<HttpEntity> client;

        private String username;
        private long releaseId;

        private String queryUrl;

        public Builder(AbstractHttpClient<HttpEntity> client) {
            this.client = client;
        }

        @Override
        public DeleteUserWantListRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        @Override
        public DeleteUserWantListRequestBuilder releaseId(long releaseId) {
            this.releaseId = releaseId;
            return this;
        }

        @Override
        public DeleteUserWantListRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .USER_DELETE_WANT_LIST
                    .getEndpoint()
                    .replace("{username}", username)
                    .replace("{release_id}", String.valueOf(releaseId));
            return new DefaultDeleteUserWantListRequest(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "client=" + client +
                    ", username='" + username + '\'' +
                    ", releaseId=" + releaseId +
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
            return Objects.hash(client, username, releaseId, queryUrl);
        }
    }

    @Override
    public CompletableFuture<Void> supplyFuture() {
        return CompletableFuture.runAsync(() -> client.execute(new HttpDelete(queryUrl)));
    }

    @Override
    public String toString() {
        return "DefaultDeleteUserWantListRequest{" +
                "client=" + client +
                ", queryUrl='" + queryUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultDeleteUserWantListRequest that = (DefaultDeleteUserWantListRequest) o;
        return Objects.equals(client, that.client) && Objects.equals(queryUrl, that.queryUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, queryUrl);
    }
}
