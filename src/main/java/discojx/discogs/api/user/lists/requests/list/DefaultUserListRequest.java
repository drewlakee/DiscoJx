package discojx.discogs.api.user.lists.requests.list;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.models.UserList;
import discojx.requests.AbstractRequest;
import discojx.requests.AbstractRequestBuilder;
import discojx.utils.json.JsonUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultUserListRequest extends AbstractRequest
        implements UserListRequest {

    public DefaultUserListRequest(Builder builder) {
        super(builder);
    }

    public static class Builder extends AbstractRequestBuilder
            implements UserListRequestBuilder {

        private long listId;

        public Builder(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public UserListRequestBuilder listId(long listId) {
            this.listId = listId;
            return this;
        }

        @Override
        public UserListRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .USER_LIST
                    .getEndpoint()
                    .replace("{list_id}", String.valueOf(listId));
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
            HttpResponse response = client.execute(new HttpGet(queryUrl));

            UserList userList;
            try {
                userList = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(response.getEntity().getContent(), UserList.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return userList;
        });
    }
}
