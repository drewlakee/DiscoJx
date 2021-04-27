package discojx.discogs.api.user.lists.requests.list;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.UserList;
import discojx.utils.json.JsonUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultUserListRequest implements UserListRequest {

    protected final AbstractHttpClient<HttpEntity> client;

    private final String queryUrl;

    public DefaultUserListRequest(Builder builder) {
        this.client = builder.client;
        this.queryUrl = builder.queryUrl;
    }

    public static class Builder implements UserListRequestBuilder {

        private final AbstractHttpClient<HttpEntity> client;

        private long listId;

        private String queryUrl;

        public Builder(AbstractHttpClient<HttpEntity> client) {
            this.client = client;
        }

        @Override
        public UserListRequestBuilder listId(long listId) {
            this.listId = listId;
            return this;
        }

        @Override
        public UserListRequest build() {
            this.queryUrl = DiscogsApiEndpoints.USER_LIST.getEndpoint().replace("{list_id}", String.valueOf(listId));
            return new DefaultUserListRequest(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "client=" + client +
                    ", listId=" + listId +
                    ", queryUrl='" + queryUrl + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return listId == builder.listId && Objects.equals(client, builder.client) && Objects.equals(queryUrl, builder.queryUrl);
        }

        @Override
        public int hashCode() {
            return Objects.hash(client, listId, queryUrl);
        }
    }

    @Override
    public CompletableFuture<UserList> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            Optional<HttpEntity> execute = client.execute(new HttpGet(queryUrl));
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            UserList userList;
            try {
                userList = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(httpEntity.getContent(), UserList.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return userList;
        });
    }

    @Override
    public String toString() {
        return "DefaultListRequest{" +
                "client=" + client +
                ", queryUrl='" + queryUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultUserListRequest that = (DefaultUserListRequest) o;
        return Objects.equals(client, that.client) && Objects.equals(queryUrl, that.queryUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, queryUrl);
    }
}
