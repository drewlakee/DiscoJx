package discojx.discogs.api.user.collection.requests.collection.folder.delete;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.requests.AbstractRequest;
import discojx.requests.AbstractRequestBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class DefaultDeleteUserFolderRequest extends AbstractRequest
        implements DeleteUserFolderRequest {

    public DefaultDeleteUserFolderRequest(Builder builder) {
        super(builder);
    }

    public static class Builder extends AbstractRequestBuilder
            implements DeleteUserFolderRequestBuilder {

        private String username;
        private long folderId;

        public Builder(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public DeleteUserFolderRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        @Override
        public DeleteUserFolderRequestBuilder folderId(long folderId) {
            this.folderId = folderId;
            return this;
        }

        @Override
        public DeleteUserFolderRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .USER_COLLECTION_DELETE_FOLDER
                    .getEndpoint()
                    .replace("{username}", username)
                    .replace("{folder_id}", String.valueOf(folderId));
            return new DefaultDeleteUserFolderRequest(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "client=" + client +
                    ", username='" + username + '\'' +
                    ", folderId=" + folderId +
                    ", queryUrl='" + queryUrl + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return folderId == builder.folderId && Objects.equals(client, builder.client) && Objects.equals(username, builder.username) && Objects.equals(queryUrl, builder.queryUrl);
        }

        @Override
        public int hashCode() {
            return Objects.hash(client, username, folderId, queryUrl);
        }
    }

    @Override
    public CompletableFuture<HttpResponse> executeAsync() {
        return CompletableFuture.supplyAsync(() -> client.execute(new HttpDelete(queryUrl)));
    }
}
