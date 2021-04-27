package discojx.discogs.api.user.collection.requests.collection.folder.edit;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.UserFolders;
import discojx.utils.json.JsonUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultEditUserFolderRequest implements EditUserFolderRequest {

    protected final AbstractHttpClient<HttpEntity> client;

    protected final String queryUrl;
    protected final ObjectNode jsonObject;

    public DefaultEditUserFolderRequest(Builder builder) {
        this.client = builder.client;
        this.queryUrl = builder.queryUrl;
        this.jsonObject = builder.jsonObject;
    }

    public static class Builder implements EditUserFolderRequestBuilder {

        private final AbstractHttpClient<HttpEntity> client;

        private String username;
        private long folderId;
        private String name;

        private String queryUrl;
        private ObjectNode jsonObject;

        public Builder(AbstractHttpClient<HttpEntity> client) {
            this.client = client;
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
    public CompletableFuture<UserFolders.UserFolder> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            HttpPost request = new HttpPost(queryUrl);
            request.setHeader("Content-Type", "application/json");
            request.setEntity(new StringEntity(jsonObject.toString(), "UTF-8"));
            Optional<HttpEntity> execute = client.execute(request);
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            UserFolders.UserFolder userFolder;
            try {
                userFolder = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(httpEntity.getContent(), UserFolders.UserFolder.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return userFolder;
        });
    }

    @Override
    public String toString() {
        return "DefaultEditUserFolderRequest{" +
                "client=" + client +
                ", queryUrl='" + queryUrl + '\'' +
                ", jsonObject=" + jsonObject +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultEditUserFolderRequest that = (DefaultEditUserFolderRequest) o;
        return Objects.equals(client, that.client) && Objects.equals(queryUrl, that.queryUrl) && Objects.equals(jsonObject, that.jsonObject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, queryUrl, jsonObject);
    }
}
