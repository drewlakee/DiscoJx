package discojx.discogs.api.marketplace.order.requests.list;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.MarketplaceListOrders;
import discojx.requests.AbstractPathParameterizedRequestBuilder;
import discojx.requests.AbstractRequest;
import discojx.requests.AbstractRequestBuilder;
import discojx.utils.json.JsonUtils;
import discojx.utils.requests.RequestPathParametersConstructor;
import discojx.utils.requests.StringBuilderSequentialRequestPathParametersConstructor;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultMarketplaceListOrdersRequest extends AbstractRequest
        implements MarketplaceListOrdersRequest {

    public DefaultMarketplaceListOrdersRequest(AbstractRequestBuilder builder) {
        super(builder);
    }

    public static class Builder extends AbstractPathParameterizedRequestBuilder<RequestPathParametersConstructor>
            implements MarketplaceListOrdersRequestBuilder {

        private static SimpleDateFormat iso8601DateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

        private String status;
        private Date createdAfter;
        private Date createdBefore;
        private int page;
        private int perPage;
        private String sort;
        private String sortOrder;
        private boolean archived;

        public Builder(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public MarketplaceListOrdersRequestBuilder status(String status) {
            this.status = status;
            return this;
        }

        @Override
        public MarketplaceListOrdersRequestBuilder createdAfter(Date createdAfter) {
            this.createdAfter = createdAfter;
            return this;
        }

        @Override
        public MarketplaceListOrdersRequestBuilder createdBefore(Date createdBefore) {
            this.createdBefore = createdBefore;
            return this;
        }

        @Override
        public MarketplaceListOrdersRequestBuilder archived(boolean archived) {
            this.archived = archived;
            return this;
        }

        @Override
        public MarketplaceListOrdersRequestBuilder page(int page) {
            this.page = page;
            return this;
        }

        @Override
        public MarketplaceListOrdersRequestBuilder perPage(int perPage) {
            this.perPage = perPage;
            return this;
        }

        @Override
        public MarketplaceListOrdersRequestBuilder sort(String sort) {
            this.sort = sort;
            return this;
        }

        @Override
        public MarketplaceListOrdersRequestBuilder sortOrder(String sortOrder) {
            this.sortOrder = sortOrder;
            return this;
        }

        @Override
        public MarketplaceListOrdersRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .MARKETPLACE_LIST_ORDERS
                    .getEndpointWith(constructPathParameters().toParametersString());
            return new DefaultMarketplaceListOrdersRequest(this);
        }

        @Override
        public RequestPathParametersConstructor constructPathParameters() {
            StringBuilderSequentialRequestPathParametersConstructor parameters =
                    new StringBuilderSequentialRequestPathParametersConstructor();

            if (page > 0) parameters.append("page", page);
            if (perPage > 0) parameters.append("per_page", perPage);
            if (status != null) parameters.append("status", status);
            if (createdAfter != null) parameters.append("created_after", iso8601DateFormat.format(createdAfter));
            if (createdBefore != null) parameters.append("created_before", iso8601DateFormat.format(createdBefore));
            if (archived) parameters.append("archived", true);
            if (sort != null) parameters.append("sort", sort);
            if (sortOrder != null) parameters.append("sort_order", sortOrder);

            return parameters;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "status='" + status + '\'' +
                    ", createdAfter=" + createdAfter +
                    ", createdBefore=" + createdBefore +
                    ", page=" + page +
                    ", perPage=" + perPage +
                    ", sort='" + sort + '\'' +
                    ", sortOrder='" + sortOrder + '\'' +
                    ", archived=" + archived +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Builder builder = (Builder) o;
            return page == builder.page && perPage == builder.perPage && archived == builder.archived && Objects.equals(status, builder.status) && Objects.equals(createdAfter, builder.createdAfter) && Objects.equals(createdBefore, builder.createdBefore) && Objects.equals(sort, builder.sort) && Objects.equals(sortOrder, builder.sortOrder);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), status, createdAfter, createdBefore, page, perPage, sort, sortOrder, archived);
        }
    }

    @Override
    public CompletableFuture<MarketplaceListOrders> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            HttpResponse response = client.execute(new HttpGet(queryUrl));

            MarketplaceListOrders marketplaceListOrders;
            try {
                marketplaceListOrders = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(response.getEntity().getContent(), MarketplaceListOrders.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return marketplaceListOrders;
        });
    }
}
