package discojx.discogs.api.requests.impl;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.api.endpoints.user.collection.requests.folder.edit.EditUserFolderRequest;
import discojx.discogs.api.endpoints.user.collection.requests.folder.edit.EditUserFolderRequestBuilder;
import discojx.discogs.api.requests.AbstractJsonParameterizedRequest;
import discojx.discogs.api.requests.AbstractJsonParameterizedRequestBuilder;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.UserFolders;
import discojx.utils.json.JsonUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultEditUserFolderRequest extends AbstractJsonParameterizedRequest<ObjectNode>
        implements EditUserFolderRequest {

    public DefaultEditUserFolderRequest(Builder builder) {
        super(builder);
    }

    public static class Builder extends AbstractJsonParameterizedRequestBuilder<ObjectNode>
            implements EditUserFolderRequestBuilder {

        private String username;
        private long folderId;
        private String name;

        public Builder(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public EditUserFolderRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        @Override
        public EditUserFolderRequestBuilder folderId(long folderId) {
            this.folderId = folderId;
            return this;
        }

        @Override
        public EditUserFolderRequestBuilder name(String name) {
            this.name = name;
            return this;
        }

        @Override
        public EditUserFolderRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .USER_COLLECTION_EDIT_FOLDER
                    .getEndpoint()
                    .replace("{username}", username)
                    .replace("{folder_id}", String.valueOf(folderId));
            this.jsonObject = constructJsonParameters();
            return new DefaultEditUserFolderRequest(this);
        }

        @Override
        public ObjectNode constructJsonParameters() {
            ObjectNode jsonObject = JsonNodeFactory.instance.objectNode();

            if (name != null) jsonObject.put("name", name);

            return jsonObject;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "client=" + client +
                    ", username='" + username + '\'' +
                    ", folderId=" + folderId +
                    ", name='" + name + '\'' +
                    ", queryUrl='" + queryUrl + '\'' +
                    ", jsonObject=" + jsonObject +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return folderId == builder.folderId && Objects.equals(client, builder.client) && Objects.equals(username, builder.username) && Objects.equals(name, builder.name) && Objects.equals(queryUrl, builder.queryUrl) && Objects.equals(jsonObject, builder.jsonObject);
        }

        @Override
        public int hashCode() {
            return Objects.hash(client, username, folderId, name, queryUrl, jsonObject);
        }
    }

    @Override
    public CompletableFuture<EntityResponseWrapper<UserFolders.UserFolder>> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            HttpPost request = new HttpPost(queryUrl);
            request.setHeader("Content-Type", "application/json");
            request.setEntity(new StringEntity(jsonObject.toString(), "UTF-8"));
            HttpResponse response = client.execute(request);

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
