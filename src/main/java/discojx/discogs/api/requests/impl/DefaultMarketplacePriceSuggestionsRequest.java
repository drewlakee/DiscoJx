package discojx.discogs.api.requests.impl;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.api.endpoints.marketplace.requests.price.MarketplacePriceSuggestionsRequest;
import discojx.discogs.api.endpoints.marketplace.requests.price.MarketplacePriceSuggestionsRequestBuilder;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.requests.MarketplacePriceSuggestions;
import discojx.discogs.api.requests.AbstractRequest;
import discojx.discogs.api.requests.AbstractRequestBuilder;
import discojx.utils.json.JsonUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultMarketplacePriceSuggestionsRequest extends AbstractRequest implements MarketplacePriceSuggestionsRequest {

    public DefaultMarketplacePriceSuggestionsRequest(AbstractRequestBuilder builder) {
        super(builder);
    }

    public static class Builder extends AbstractRequestBuilder implements MarketplacePriceSuggestionsRequestBuilder {

        private long releaseId;

        public Builder(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public MarketplacePriceSuggestionsRequestBuilder releaseId(long releaseId) {
            this.releaseId = releaseId;
            return this;
        }

        @Override
        public MarketplacePriceSuggestionsRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .MARKETPLACE_PRICE_SUGGESTIONS
                    .getEndpoint()
                    .replace("{release_id}", String.valueOf(releaseId));
            return new DefaultMarketplacePriceSuggestionsRequest(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "releaseId=" + releaseId +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Builder builder = (Builder) o;
            return releaseId == builder.releaseId;
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), releaseId);
        }
    }

    @Override
    public CompletableFuture<EntityResponseWrapper<MarketplacePriceSuggestions>> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            HttpResponse response = client.execute(new HttpGet(queryUrl));

            MarketplacePriceSuggestions marketplacePriceSuggestions;
            try {
                marketplacePriceSuggestions = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(response.getEntity().getContent(), MarketplacePriceSuggestions.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return new EntityResponseWrapper<>(response, marketplacePriceSuggestions);
        });
    }
}
