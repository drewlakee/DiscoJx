package discojx.discogs.api.user.collection.requests.folders;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.UserFolders;
import discojx.utils.json.JsonUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultUserFoldersRequest implements UserFoldersRequest {

    private final AbstractHttpClient<HttpEntity> client;

    private final String queryUrl;

    public DefaultUserFoldersRequest(Builder builder) {
        this.client = builder.client;
        this.queryUrl = builder.queryUrl;
    }

    public static class Builder implements UserFoldersRequestBuilder {

        private final AbstractHttpClient<HttpEntity> client;

        private String username;

        private String queryUrl;

        public Builder(AbstractHttpClient<HttpEntity> client) {
            this.client = client;
        }

        @Override
        public UserFoldersRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        @Override
        public UserFoldersRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .USER_COLLECTION_FOLDERS
                    .getEndpoint()
                    .replace("{username}", username);
            return new DefaultUserFoldersRequest(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "client=" + client +
                    ", username='" + username + '\'' +
                    ", queryUrl='" + queryUrl + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {

            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return Objects.equals(client, builder.client) && Objects.equals(username, builder.username) && Objects.equals(queryUrl, builder.queryUrl);
        }

        @Override
        public int hashCode() {
            return Objects.hash(client, username, queryUrl);
        }
    }

    @Override
    public CompletableFuture<UserFolders> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            Optional<HttpEntity> execute = client.execute(new HttpGet(queryUrl));
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            UserFolders userFolders;
            try {
                userFolders = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(httpEntity.getContent(), UserFolders.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return userFolders;
        });
    }

    @Override
    public String toString() {
        return "DefaultUserFoldersRequest{" +
                "client=" + client +
                ", queryUrl='" + queryUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultUserFoldersRequest that = (DefaultUserFoldersRequest) o;
        return Objects.equals(client, that.client) && Objects.equals(queryUrl, that.queryUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, queryUrl);
    }
}
