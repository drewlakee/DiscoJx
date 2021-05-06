package discojx.discogs.api.requests.impl;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.api.endpoints.marketplace.order.requests.edit.MarketplaceEditOrderRequest;
import discojx.discogs.api.endpoints.marketplace.order.requests.edit.MarketplaceEditOrderRequestBuilder;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.MarketplaceOrder;
import discojx.discogs.api.requests.AbstractJsonParameterizedRequest;
import discojx.discogs.api.requests.AbstractJsonParameterizedRequestBuilder;
import discojx.utils.json.JsonUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultMarketplaceEditOrderRequest extends AbstractJsonParameterizedRequest<ObjectNode>
        implements MarketplaceEditOrderRequest {

    public DefaultMarketplaceEditOrderRequest(AbstractJsonParameterizedRequestBuilder<ObjectNode> builder) {
        super(builder);
    }

    public static class Builder extends AbstractJsonParameterizedRequestBuilder<ObjectNode>
            implements MarketplaceEditOrderRequestBuilder {

        private String orderId;
        private String status;
        private double shipping;

        public Builder(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public MarketplaceEditOrderRequestBuilder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        @Override
        public MarketplaceEditOrderRequestBuilder status(String status) {
            this.status = status;
            return this;
        }

        @Override
        public MarketplaceEditOrderRequestBuilder shipping(double shipping) {
            this.shipping = shipping;
            return this;
        }

        @Override
        public MarketplaceEditOrderRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .MARKETPLACE_EDIT_ORDER
                    .getEndpoint()
                    .replace("{order_id}", orderId);
            this.jsonObject = constructJsonParameters();
            return new DefaultMarketplaceEditOrderRequest(this);
        }

        @Override
        protected ObjectNode constructJsonParameters() {
            ObjectNode jsonObject = JsonNodeFactory.instance.objectNode();

            if (status != null) jsonObject.put("status", status);
            if (shipping > 0) jsonObject.put("shipping", shipping);

            return jsonObject;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "orderId='" + orderId + '\'' +
                    ", status='" + status + '\'' +
                    ", shipping=" + shipping +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Builder builder = (Builder) o;
            return Double.compare(builder.shipping, shipping) == 0 && Objects.equals(orderId, builder.orderId) && Objects.equals(status, builder.status);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), orderId, status, shipping);
        }
    }

    @Override
    public CompletableFuture<EntityResponseWrapper<MarketplaceOrder>> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            HttpPost request = new HttpPost(queryUrl);
            request.setHeader("Content-Type", "application/json");
            request.setEntity(new StringEntity(jsonObject.toString(), "UTF-8"));
            HttpResponse response = client.execute(request);

            MarketplaceOrder marketplaceOrder;
            try {
                marketplaceOrder = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(response.getEntity().getContent(), MarketplaceOrder.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return new EntityResponseWrapper<>(response, marketplaceOrder);
        });
    }
}
