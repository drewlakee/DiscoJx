package discojx.discogs.api.user.identity.requests.contributions;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.Contributions;
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

public class DefaultUserContributionsRequest implements UserContributionsRequest {

    protected final AbstractHttpClient<HttpEntity> client;

    private final String username;

    protected final String queryUrl;

    public DefaultUserContributionsRequest(Builder builder) {
        this.client = builder.client;
        this.username = builder.username;
        this.queryUrl = builder.queryUrl;
    }

    public static class Builder implements UserContributionsRequestBuilder {

        private final AbstractHttpClient<HttpEntity> client;

        private String username;
        private String sort;
        private String sortOrder;
        private int page;
        private int perPage;

        private String queryUrl;

        public Builder(AbstractHttpClient<HttpEntity> client) {
            this.client = client;
        }

        @Override
        public UserContributionsRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        @Override
        public UserContributionsRequestBuilder sort(String attribute) {
            this.sort = attribute;
            return this;
        }

        @Override
        public UserContributionsRequestBuilder sortOrder(String sortOrder) {
            this.sortOrder = sortOrder;
            return this;
        }

        @Override
        public UserContributionsRequestBuilder page(int page) {
            this.page = page;
            return this;
        }

        @Override
        public UserContributionsRequestBuilder perPage(int perPage) {
            this.perPage = perPage;
            return this;
        }

        @Override
        public UserContributionsRequest build() {
            this.queryUrl = DiscogsApiEndpoints.USER_CONTRIBUTIONS.getEndpointWith(constructParameters().toParametersString());
            return new DefaultUserContributionsRequest(this);
        }

        @Override
        public RequestParametersConstructor constructParameters() {
            StringBuilderSequentialRequestParametersConstructor parameters =
                    new StringBuilderSequentialRequestParametersConstructor();

            if (page > 0) parameters.append("page", page);
            if (perPage > 0) parameters.append("per_page", perPage);
            if (sort != null) parameters.append("sort", sort);
            if (sortOrder != null) parameters.append("sort_order", sortOrder);

            return parameters;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "client=" + client +
                    ", username='" + username + '\'' +
                    ", sort='" + sort + '\'' +
                    ", sortOrder='" + sortOrder + '\'' +
                    ", page=" + page +
                    ", perPage=" + perPage +
                    ", queryUrl='" + queryUrl + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return page == builder.page && perPage == builder.perPage && Objects.equals(client, builder.client) && Objects.equals(username, builder.username) && Objects.equals(sort, builder.sort) && Objects.equals(sortOrder, builder.sortOrder) && Objects.equals(queryUrl, builder.queryUrl);
        }

        @Override
        public int hashCode() {
            return Objects.hash(client, username, sort, sortOrder, page, perPage, queryUrl);
        }
    }

    @Override
    public CompletableFuture<Contributions> supplyFuture() {
        return CompletableFuture.supplyAsync(() -> {
            Optional<HttpEntity> execute = client.execute(new HttpGet(queryUrl.replace("{username}", username)));
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            Contributions contributions;
            try {
                contributions = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(httpEntity.getContent(), Contributions.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return contributions;
        });
    }

    @Override
    public String toString() {
        return "DefaultUserContributionsRequest{" +
                "client=" + client +
                ", username='" + username + '\'' +
                ", queryUrl='" + queryUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultUserContributionsRequest that = (DefaultUserContributionsRequest) o;
        return Objects.equals(client, that.client) && Objects.equals(username, that.username) && Objects.equals(queryUrl, that.queryUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, username, queryUrl);
    }
}
