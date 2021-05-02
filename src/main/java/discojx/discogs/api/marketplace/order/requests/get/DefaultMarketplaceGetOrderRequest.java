package discojx.discogs.api.marketplace.order.requests.get;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.Listing;
import discojx.discogs.objects.MarketplaceOrder;
import discojx.requests.AbstractRequest;
import discojx.requests.AbstractRequestBuilder;
import discojx.utils.json.JsonUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultMarketplaceGetOrderRequest extends AbstractRequest
        implements MarketplaceGetOrderRequest {

    public DefaultMarketplaceGetOrderRequest(AbstractRequestBuilder builder) {
        super(builder);
    }

    public static class Builder extends AbstractRequestBuilder
            implements MarketplaceGetOrderRequestBuilder {

        private String orderId;

        public Builder(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public MarketplaceGetOrderRequestBuilder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        @Override
        public MarketplaceGetOrderRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .MARKETPLACE_GET_ORDER
                    .getEndpoint()
                    .replace("{order_id}", orderId);
            return new DefaultMarketplaceGetOrderRequest(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "orderId='" + orderId + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Builder builder = (Builder) o;
            return Objects.equals(orderId, builder.orderId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), orderId);
        }
    }

    @Override
    public CompletableFuture<MarketplaceOrder> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            HttpResponse response = client.execute(new HttpGet(queryUrl));

            MarketplaceOrder marketplaceOrder;
            try {
                marketplaceOrder = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(response.getEntity().getContent(), MarketplaceOrder.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return marketplaceOrder;
        });
    }
}
