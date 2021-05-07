package discojx.discogs.api.requests.impl;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.api.endpoints.user.collection.requests.folder.UserFolderRequest;
import discojx.discogs.api.endpoints.user.collection.requests.folder.UserFolderRequestBuilder;
import discojx.discogs.api.requests.AbstractRequest;
import discojx.discogs.api.requests.AbstractRequestBuilder;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.UserFolders;
import discojx.utils.json.JsonUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultUserFolderRequest extends AbstractRequest
        implements UserFolderRequest {

    public DefaultUserFolderRequest(Builder builder) {
        super(builder);
    }

    public static class Builder extends AbstractRequestBuilder
            implements UserFolderRequestBuilder {

        private String username;
        private long folderId;

        public Builder(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public UserFolderRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        @Override
        public UserFolderRequestBuilder folderId(long folderId) {
            this.folderId = folderId;
            return this;
        }

        @Override
        public UserFolderRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .USER_COLLECTION_FOLDER
                    .getEndpoint()
                    .replace("{username}", username)
                    .replace("{folder_id}", String.valueOf(folderId));
            return new DefaultUserFolderRequest(this);
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
    public CompletableFuture<EntityResponseWrapper<UserFolders.UserFolder>> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            HttpResponse response = client.execute(new HttpGet(queryUrl));

            UserFolders.UserFolder userFolder;
            try {
                userFolder = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(response.getEntity().getContent(), UserFolders.UserFolder.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return new EntityResponseWrapper<>(response, userFolder);
        });
    }
}
