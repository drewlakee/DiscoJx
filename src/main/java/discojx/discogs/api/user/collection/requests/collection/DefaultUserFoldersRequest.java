package discojx.discogs.api.user.collection.requests.collection;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.UserFolders;
import discojx.requests.AbstractRequest;
import discojx.requests.AbstractRequestBuilder;
import discojx.utils.json.JsonUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultUserFoldersRequest extends AbstractRequest
        implements UserFoldersRequest {

    public DefaultUserFoldersRequest(Builder builder) {
        super(builder);
    }

    public static class Builder extends AbstractRequestBuilder
            implements UserFoldersRequestBuilder {

        private String username;

        public Builder(AbstractHttpClient client) {
            super(client);
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
            HttpResponse response = client.execute(new HttpGet(queryUrl));

            UserFolders userFolders;
            try {
                userFolders = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(response.getEntity().getContent(), UserFolders.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return userFolders;
        });
    }
}
