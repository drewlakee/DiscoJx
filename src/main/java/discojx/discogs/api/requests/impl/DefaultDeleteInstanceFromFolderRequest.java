package discojx.discogs.api.requests.impl;

import discojx.http.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.api.endpoints.user.collection.requests.release.delete.DeleteInstanceFromFolderRequest;
import discojx.discogs.api.endpoints.user.collection.requests.release.delete.DeleteInstanceFromFolderRequestBuilder;
import discojx.discogs.api.requests.AbstractRequest;
import discojx.discogs.api.requests.AbstractRequestBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class DefaultDeleteInstanceFromFolderRequest extends AbstractRequest
        implements DeleteInstanceFromFolderRequest {

    private final boolean isUncategorized;

    public DefaultDeleteInstanceFromFolderRequest(Builder builder) {
        super(builder);
        this.isUncategorized = builder.isUncategorized;
    }

    public static class Builder extends AbstractRequestBuilder
            implements DeleteInstanceFromFolderRequestBuilder {

        private String username;
        private long folderId;
        private long releaseId;
        private long instanceId;
        private boolean isUncategorized;

        public Builder(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public DeleteInstanceFromFolderRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        @Override
        public DeleteInstanceFromFolderRequestBuilder folderId(long folderId) {
            this.folderId = folderId;
            return this;
        }

        @Override
        public DeleteInstanceFromFolderRequestBuilder releaseId(long releaseId) {
            this.releaseId = releaseId;
            return this;
        }

        @Override
        public DeleteInstanceFromFolderRequestBuilder instanceId(long instanceId) {
            this.instanceId = instanceId;
            return this;
        }

        @Override
        public DeleteInstanceFromFolderRequestBuilder makeUncategorized(boolean isUncategorized) {
            this.isUncategorized = isUncategorized;
            return this;
        }

        @Override
        public DeleteInstanceFromFolderRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .USER_COLLECTION_DELETE_INSTANCE_FROM_FOLDER
                    .getEndpoint()
                    .replace("{username}", username)
                    .replace("{folder_id}", String.valueOf(folderId))
                    .replace("{release_id}", String.valueOf(releaseId))
                    .replace("{instance_id}", String.valueOf(instanceId));
            return new DefaultDeleteInstanceFromFolderRequest(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "username='" + username + '\'' +
                    ", folderId=" + folderId +
                    ", releaseId=" + releaseId +
                    ", instanceId=" + instanceId +
                    ", isUncategorized=" + isUncategorized +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Builder builder = (Builder) o;
            return folderId == builder.folderId && releaseId == builder.releaseId && instanceId == builder.instanceId && isUncategorized == builder.isUncategorized && Objects.equals(username, builder.username);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), username, folderId, releaseId, instanceId, isUncategorized);
        }
    }

    @Override
    public CompletableFuture<HttpResponse> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            HttpRequestBase request;

            if (isUncategorized) {
                request = new HttpPost(queryUrl);
            } else {
                request = new HttpDelete(queryUrl);
            }

            return client.execute(request);
        });
    }

    @Override
    public String toString() {
        return "DefaultDeleteInstanceFromFolderRequest{" +
                "isUncategorized=" + isUncategorized +
                ", client=" + client +
                ", queryUrl='" + queryUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DefaultDeleteInstanceFromFolderRequest that = (DefaultDeleteInstanceFromFolderRequest) o;
        return isUncategorized == that.isUncategorized;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isUncategorized);
    }
}
