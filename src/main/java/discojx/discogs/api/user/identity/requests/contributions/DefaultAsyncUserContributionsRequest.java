package discojx.discogs.api.user.identity.requests.contributions;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsEndpoints;
import discojx.discogs.objects.Contributions;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultAsyncUserContributionsRequest implements AsyncUserContributionsRequest {

    protected final AbstractHttpClient<HttpEntity> client;

    protected static final ObjectMapper jsonMapper = new JsonMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private final String username;

    protected final String endpointParameters;

    public DefaultAsyncUserContributionsRequest(Builder builder) {
        this.client = builder.client;
        this.username = builder.username;
        this.endpointParameters = builder.endpointParameters;
    }

    public static class Builder implements AsyncUserContributionsRequestBuilder {

        private final AbstractHttpClient<HttpEntity> client;

        private String username;
        private String sort;
        private String sortOrder;
        private int page;
        private int perPage;

        private String endpointParameters;

        public Builder(AbstractHttpClient<HttpEntity> client) {
            this.client = client;
        }

        @Override
        public AsyncUserContributionsRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        @Override
        public AsyncUserContributionsRequestBuilder sort(String attribute) {
            this.sort = attribute;
            return this;
        }

        @Override
        public AsyncUserContributionsRequestBuilder sortOrder(String sortOrder) {
            this.sortOrder = sortOrder;
            return this;
        }

        @Override
        public AsyncUserContributionsRequestBuilder page(int page) {
            this.page = page;
            return this;
        }

        @Override
        public AsyncUserContributionsRequestBuilder perPage(int perPage) {
            this.perPage = perPage;
            return this;
        }

        @Override
        public AsyncUserContributionsRequest build() {
            this.endpointParameters = constructParameters();
            return new DefaultAsyncUserContributionsRequest(this);
        }

        @Override
        public String constructParameters() {
            List<String> parameters = new ArrayList<>();

            if (page > 0) parameters.add("page=" + page);
            if (perPage > 0) parameters.add("per_page=" + perPage);
            if (sort != null) parameters.add("sort=" + sort);
            if (sortOrder != null) parameters.add("sort_order=" + sortOrder);

            if (parameters.isEmpty()) {
                return "";
            } else {
                return "?" + String.join("&", parameters);
            }
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
                    ", endpointParameters='" + endpointParameters + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return page == builder.page && perPage == builder.perPage && Objects.equals(client, builder.client) && Objects.equals(username, builder.username) && Objects.equals(sort, builder.sort) && Objects.equals(sortOrder, builder.sortOrder) && Objects.equals(endpointParameters, builder.endpointParameters);
        }

        @Override
        public int hashCode() {
            return Objects.hash(client, username, sort, sortOrder, page, perPage, endpointParameters);
        }
    }

    @Override
    public CompletableFuture<Contributions> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            Optional<HttpEntity> execute = client.execute(new HttpGet(DiscogsEndpoints.USER_CONTRIBUTIONS.getEndpoint().replace("{username}", username) + endpointParameters));
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            Contributions contributions;
            try {
                contributions = jsonMapper.readValue(httpEntity.getContent(), Contributions.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return contributions;
        });
    }


    @Override
    public String toString() {
        return "DefaultAsyncUserContributionsRequest{" +
                "client=" + client +
                ", username='" + username + '\'' +
                ", endpointParameters='" + endpointParameters + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultAsyncUserContributionsRequest that = (DefaultAsyncUserContributionsRequest) o;
        return Objects.equals(client, that.client) && Objects.equals(username, that.username) && Objects.equals(endpointParameters, that.endpointParameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, username, endpointParameters);
    }
}
