package discojx.discogs.api.user.identity.requests.contributions;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.requests.Contributions;
import discojx.requests.AbstractPathParameterizedRequestBuilder;
import discojx.requests.AbstractRequest;
import discojx.utils.json.JsonUtils;
import discojx.utils.requests.RequestPathParametersConstructor;
import discojx.utils.requests.StringBuilderSequentialRequestPathParametersConstructor;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultUserContributionsRequest extends AbstractRequest
        implements UserContributionsRequest {

    public DefaultUserContributionsRequest(Builder builder) {
        super(builder);
    }

    public static class Builder extends AbstractPathParameterizedRequestBuilder<RequestPathParametersConstructor>
            implements UserContributionsRequestBuilder {

        private String username;
        private String sort;
        private String sortOrder;
        private int page;
        private int perPage;

        public Builder(AbstractHttpClient client) {
            super(client);
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
            this.queryUrl = DiscogsApiEndpoints
                    .USER_CONTRIBUTIONS
                    .getEndpointWith(constructPathParameters().toParametersString())
                    .replace("{username}", username);
            return new DefaultUserContributionsRequest(this);
        }

        @Override
        public RequestPathParametersConstructor constructPathParameters() {
            StringBuilderSequentialRequestPathParametersConstructor parameters =
                    new StringBuilderSequentialRequestPathParametersConstructor();

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
    public CompletableFuture<Contributions> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            HttpResponse response = client.execute(new HttpGet(queryUrl));

            Contributions contributions;
            try {
                contributions = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(response.getEntity().getContent(), Contributions.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return contributions;
        });
    }
}
