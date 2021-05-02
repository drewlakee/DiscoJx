package discojx.discogs.api.marketplace.requests.inventory;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.MarketplaceInventory;
import discojx.requests.AbstractPathParameterizedRequestBuilder;
import discojx.requests.AbstractRequest;
import discojx.requests.AbstractRequestBuilder;
import discojx.utils.json.JsonUtils;
import discojx.utils.requests.RequestPathParametersConstructor;
import discojx.utils.requests.StringBuilderSequentialRequestPathParametersConstructor;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultMarketplaceInventoryRequest extends AbstractRequest
        implements MarketplaceInventoryRequest {

    public DefaultMarketplaceInventoryRequest(AbstractRequestBuilder builder) {
        super(builder);
    }

    public static class Builder extends AbstractPathParameterizedRequestBuilder<RequestPathParametersConstructor>
            implements MarketplaceInventoryRequestBuilder {

        private String username;
        private String status;
        private int page;
        private int perPage;
        private String sort;
        private String sortOrder;

        public Builder(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public MarketplaceInventoryRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        @Override
        public MarketplaceInventoryRequestBuilder status(String status) {
            this.status = status;
            return this;
        }

        @Override
        public MarketplaceInventoryRequestBuilder page(int page) {
            this.page = page;
            return this;
        }

        @Override
        public MarketplaceInventoryRequestBuilder perPage(int perPage) {
            this.perPage = perPage;
            return this;
        }

        @Override
        public MarketplaceInventoryRequestBuilder sort(String attribute) {
            this.sort = attribute;
            return this;
        }

        @Override
        public MarketplaceInventoryRequestBuilder sortOrder(String sortOrder) {
            this.sort = sortOrder;
            return this;
        }

        @Override
        public MarketplaceInventoryRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .MARKETPLACE_INVENTORY
                    .getEndpointWith(constructPathParameters().toParametersString())
                    .replace("{username}", username);
            return new DefaultMarketplaceInventoryRequest(this);
        }

        @Override
        public RequestPathParametersConstructor constructPathParameters() {
            StringBuilderSequentialRequestPathParametersConstructor parameters =
                    new StringBuilderSequentialRequestPathParametersConstructor();

            if (status != null) parameters.append("status", status);
            if (page > 0) parameters.append("page", page);
            if (perPage > 0) parameters.append("per_page", perPage);
            if (sort != null) parameters.append("sort", sort);
            if (sortOrder != null) parameters.append("sort_order", sortOrder);

            return parameters;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "username='" + username + '\'' +
                    ", status='" + status + '\'' +
                    ", page=" + page +
                    ", perPage=" + perPage +
                    ", sort='" + sort + '\'' +
                    ", sortOrder='" + sortOrder + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Builder builder = (Builder) o;
            return page == builder.page && perPage == builder.perPage && Objects.equals(username, builder.username) && Objects.equals(status, builder.status) && Objects.equals(sort, builder.sort) && Objects.equals(sortOrder, builder.sortOrder);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), username, status, page, perPage, sort, sortOrder);
        }
    }

    @Override
    public CompletableFuture<MarketplaceInventory> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            HttpResponse response = client.execute(new HttpGet(queryUrl));

            MarketplaceInventory marketplaceInventory;
            try {
                marketplaceInventory = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(response.getEntity().getContent(), MarketplaceInventory.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return marketplaceInventory;
        });
    }
}
