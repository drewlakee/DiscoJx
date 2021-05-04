package discojx.discogs.api.marketplace.order.requests.messages.get;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.ListOrderMessages;
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

public class DefaultMarketplaceListOrderMessagesRequest extends AbstractRequest
        implements MarketplaceListOrderMessagesRequest {

    public DefaultMarketplaceListOrderMessagesRequest(AbstractRequestBuilder builder) {
        super(builder);
    }

    public static class Builder extends AbstractPathParameterizedRequestBuilder<RequestPathParametersConstructor>
            implements MarketplaceListOrderMessagesRequestBuilder {

        private int page;
        private int perPage;
        private String orderId;

        public Builder(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public MarketplaceListOrderMessagesRequestBuilder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        @Override
        public MarketplaceListOrderMessagesRequestBuilder page(int page) {
            this.page = page;
            return this;
        }

        @Override
        public MarketplaceListOrderMessagesRequestBuilder perPage(int perPage) {
            this.perPage = perPage;
            return this;
        }

        @Override
        public MarketplaceListOrderMessagesRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .MARKETPLACE_LIST_ORDER_MESSAGES
                    .getEndpointWith(constructPathParameters().toParametersString())
                    .replace("{order_id}", orderId);
            return new DefaultMarketplaceListOrderMessagesRequest(this);
        }

        @Override
        public RequestPathParametersConstructor constructPathParameters() {
            StringBuilderSequentialRequestPathParametersConstructor parameters =
                    new StringBuilderSequentialRequestPathParametersConstructor();

            if (page > 0) parameters.append("page", page);
            if (perPage > 0) parameters.append("per_page", perPage);

            return parameters;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "page=" + page +
                    ", perPage=" + perPage +
                    ", orderId='" + orderId + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Builder builder = (Builder) o;
            return page == builder.page && perPage == builder.perPage && Objects.equals(orderId, builder.orderId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), page, perPage, orderId);
        }
    }

    @Override
    public CompletableFuture<ListOrderMessages> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            HttpResponse response = client.execute(new HttpGet(queryUrl));

            ListOrderMessages listOrderMessages;
            try {
                listOrderMessages = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(response.getEntity().getContent(), ListOrderMessages.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return listOrderMessages;
        });
    }
}
