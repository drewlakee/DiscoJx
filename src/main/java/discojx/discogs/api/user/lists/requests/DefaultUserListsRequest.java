package discojx.discogs.api.user.lists.requests;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.UserLists;
import discojx.utils.json.JsonUtils;
import discojx.utils.requests.RequestParametersConstructor;
import discojx.utils.requests.StringBuilderSequentialRequestParametersConstructor;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultUserListsRequest implements UserListsRequest {

    protected final AbstractHttpClient<HttpEntity> client;

    private final String queryUrl;

    public DefaultUserListsRequest(Builder builder) {
        this.client = builder.client;
        this.queryUrl = builder.queryUrl;
    }

    public static class Builder implements UserListsRequestBuilder {

        private final AbstractHttpClient<HttpEntity> client;

        private int page;
        private int perPage;
        private String username;

        private String queryUrl;

        public Builder(AbstractHttpClient<HttpEntity> client) {
            this.client = client;
        }

        @Override
        public UserListsRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        @Override
        public UserListsRequestBuilder page(int page) {
            this.page = page;
            return this;
        }

        @Override
        public UserListsRequestBuilder perPage(int perPage) {
            this.perPage = perPage;
            return this;
        }

        @Override
        public UserListsRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .USER_LISTS
                    .getEndpointWith(constructPathParameters().toParametersString())
                    .replace("{username}", username);
            return new DefaultUserListsRequest(this);
        }

        @Override
        public RequestParametersConstructor constructPathParameters() {
            StringBuilderSequentialRequestParametersConstructor parameters =
                    new StringBuilderSequentialRequestParametersConstructor();

            if (page > 0) parameters.append("page", page);
            if (perPage > 0) parameters.append("per_page", perPage);

            return parameters;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "client=" + client +
                    ", page=" + page +
                    ", perPage=" + perPage +
                    ", username='" + username + '\'' +
                    ", queryUrl='" + queryUrl + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return page == builder.page && perPage == builder.perPage && Objects.equals(client, builder.client) && Objects.equals(username, builder.username) && Objects.equals(queryUrl, builder.queryUrl);
        }

        @Override
        public int hashCode() {
            return Objects.hash(client, page, perPage, username, queryUrl);
        }
    }

    @Override
    public CompletableFuture<UserLists> supplyFuture() {
        return CompletableFuture.supplyAsync(() -> {
            Optional<HttpEntity> execute = client.execute(new HttpGet(queryUrl));
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            UserLists userLists;
            try {
                userLists = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(httpEntity.getContent(), UserLists.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return userLists;
        });
    }

    @Override
    public String toString() {
        return "DefaultUserListsRequest{" +
                "client=" + client +
                ", queryUrl='" + queryUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultUserListsRequest that = (DefaultUserListsRequest) o;
        return Objects.equals(client, that.client) && Objects.equals(queryUrl, that.queryUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, queryUrl);
    }
}
