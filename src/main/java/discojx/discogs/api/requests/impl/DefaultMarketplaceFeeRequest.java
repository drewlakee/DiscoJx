package discojx.discogs.api.requests.impl;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.api.endpoints.marketplace.requests.fee.MarketplaceFeeRequest;
import discojx.discogs.api.endpoints.marketplace.requests.fee.MarketplaceFeeRequestBuilder;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.Fee;
import discojx.discogs.api.requests.AbstractRequest;
import discojx.discogs.api.requests.AbstractRequestBuilder;
import discojx.utils.json.JsonUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultMarketplaceFeeRequest extends AbstractRequest implements MarketplaceFeeRequest {

    public DefaultMarketplaceFeeRequest(AbstractRequestBuilder builder) {
        super(builder);
    }

    public static class Builder extends AbstractRequestBuilder implements MarketplaceFeeRequestBuilder {

        private double price;

        public Builder(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public MarketplaceFeeRequestBuilder price(double price) {
            this.price = price;
            return this;
        }

        @Override
        public MarketplaceFeeRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .MARKETPLACE_FEE
                    .getEndpoint()
                    .replace("{price}", String.valueOf(price));
            return new DefaultMarketplaceFeeRequest(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "price=" + price +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Builder builder = (Builder) o;
            return Double.compare(builder.price, price) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), price);
        }
    }

    @Override
    public CompletableFuture<EntityResponseWrapper<Fee>> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            HttpResponse response = client.execute(new HttpGet(queryUrl));

            Fee fee;
            try {
                fee = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(response.getEntity().getContent(), Fee.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return new EntityResponseWrapper<>(response, fee);
        });
    }
}
