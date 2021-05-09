package discojx.discogs.api.requests.impl;

import discojx.http.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.api.endpoints.marketplace.listing.requests.delete.MarketplaceDeleteListingRequest;
import discojx.discogs.api.endpoints.marketplace.listing.requests.delete.MarketplaceDeleteListingRequestBuilder;
import discojx.discogs.api.requests.AbstractRequest;
import discojx.discogs.api.requests.AbstractRequestBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class DefaultMarketplaceDeleteListingRequest extends AbstractRequest
        implements MarketplaceDeleteListingRequest {

    public DefaultMarketplaceDeleteListingRequest(AbstractRequestBuilder builder) {
        super(builder);
    }

    public static class Builder extends AbstractRequestBuilder
            implements MarketplaceDeleteListingRequestBuilder {

        private long listingId;

        public Builder(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public MarketplaceDeleteListingRequestBuilder listingId(long listingId) {
            this.listingId = listingId;
            return this;
        }

        @Override
        public MarketplaceDeleteListingRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .MARKETPLACE_DELETE_LISTING
                    .getEndpoint()
                    .replace("{listing_id}", String.valueOf(listingId));
            return new DefaultMarketplaceDeleteListingRequest(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "listingId=" + listingId +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Builder builder = (Builder) o;
            return listingId == builder.listingId;
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), listingId);
        }
    }

    @Override
    public CompletableFuture<HttpResponse> executeAsync() {
        return CompletableFuture.supplyAsync(() -> client.execute(new HttpDelete(queryUrl)));
    }
}
