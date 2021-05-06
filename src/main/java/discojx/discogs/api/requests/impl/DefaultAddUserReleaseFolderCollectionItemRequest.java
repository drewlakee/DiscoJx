package discojx.discogs.api.requests.impl;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.api.endpoints.user.collection.requests.folder.release.add.AddUserReleaseFolderCollectionItemRequest;
import discojx.discogs.api.endpoints.user.collection.requests.folder.release.add.AddUserReleaseFolderCollectionItemRequestBuilder;
import discojx.discogs.api.requests.AbstractRequest;
import discojx.discogs.api.requests.AbstractRequestBuilder;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.UserReleaseCollectionItems;
import discojx.utils.json.JsonUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultAddUserReleaseFolderCollectionItemRequest extends AbstractRequest
        implements AddUserReleaseFolderCollectionItemRequest {

    public DefaultAddUserReleaseFolderCollectionItemRequest(AbstractRequestBuilder builder) {
        super(builder);
    }

    public static class Builder extends AbstractRequestBuilder
            implements AddUserReleaseFolderCollectionItemRequestBuilder {

        private String username;
        private long folderId;
        private long releaseId;

        public Builder(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public AddUserReleaseFolderCollectionItemRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        @Override
        public AddUserReleaseFolderCollectionItemRequestBuilder folderId(long folderId) {
            this.folderId = folderId;
            return this;
        }

        @Override
        public AddUserReleaseFolderCollectionItemRequestBuilder releaseId(long releaseId) {
            this.releaseId = releaseId;
            return this;
        }

        @Override
        public AddUserReleaseFolderCollectionItemRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .USER_COLLECTION_ADD_RELEASE_ITEM_TO_FOLDER
                    .getEndpoint()
                    .replace("{username}", username)
                    .replace("{release_id}", String.valueOf(releaseId))
                    .replace("{folder_id}", String.valueOf(folderId));
            return new DefaultAddUserReleaseFolderCollectionItemRequest(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "username='" + username + '\'' +
                    ", folderId=" + folderId +
                    ", releaseId=" + releaseId +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Builder builder = (Builder) o;
            return folderId == builder.folderId && releaseId == builder.releaseId && Objects.equals(username, builder.username);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), username, folderId, releaseId);
        }
    }

    @Override
    public CompletableFuture<EntityResponseWrapper<UserReleaseCollectionItems.Release.Short>> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            HttpResponse response = client.execute(new HttpPost(queryUrl));

            UserReleaseCollectionItems.Release.Short userReleaseCollectionFolderItem;
            try {
                userReleaseCollectionFolderItem = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(response.getEntity().getContent(), UserReleaseCollectionItems.Release.Short.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return new EntityResponseWrapper<>(response, userReleaseCollectionFolderItem);
        });
    }
}
