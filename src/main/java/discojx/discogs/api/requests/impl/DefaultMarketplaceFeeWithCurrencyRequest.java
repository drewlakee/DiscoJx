package discojx.discogs.api.requests.impl;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.api.endpoints.marketplace.requests.fee.currency.MarketplaceFeeWithCurrencyRequest;
import discojx.discogs.api.endpoints.marketplace.requests.fee.currency.MarketplaceFeeWithCurrencyRequestBuilder;
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

public class DefaultMarketplaceFeeWithCurrencyRequest extends AbstractRequest implements MarketplaceFeeWithCurrencyRequest {

    public DefaultMarketplaceFeeWithCurrencyRequest(AbstractRequestBuilder builder) {
        super(builder);
    }

    public static class Builder extends AbstractRequestBuilder implements MarketplaceFeeWithCurrencyRequestBuilder {

        private double price;
        private String currency;

        public Builder(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public MarketplaceFeeWithCurrencyRequestBuilder price(double price) {
            this.price = price;
            return this;
        }

        @Override
        public MarketplaceFeeWithCurrencyRequestBuilder currency(String currency) {
            this.currency = currency;
            return this;
        }

        @Override
        public MarketplaceFeeWithCurrencyRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .MARKETPLACE_FEE_WITH_CURRENCY
                    .getEndpoint()
                    .replace("{price}", String.valueOf(price))
                    .replace("{currency}", currency);
            return new DefaultMarketplaceFeeWithCurrencyRequest(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "price=" + price +
                    ", currency='" + currency + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Builder builder = (Builder) o;
            return Double.compare(builder.price, price) == 0 && Objects.equals(currency, builder.currency);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), price, currency);
        }
    }

    @Override
    public CompletableFuture<Fee> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            HttpResponse response = client.execute(new HttpGet(queryUrl));

            Fee fee;
            try {
                fee = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(response.getEntity().getContent(), Fee.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return fee;
        });
    }
}
