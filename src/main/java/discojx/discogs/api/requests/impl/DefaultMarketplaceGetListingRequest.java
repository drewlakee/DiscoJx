package discojx.discogs.api.requests.impl;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.api.endpoints.marketplace.listing.requests.get.MarketplaceGetListingRequest;
import discojx.discogs.api.endpoints.marketplace.listing.requests.get.MarketplaceGetListingRequestBuilder;
import discojx.discogs.objects.models.Listing;
import discojx.discogs.api.requests.AbstractPathParameterizedRequestBuilder;
import discojx.discogs.api.requests.AbstractRequest;
import discojx.discogs.api.requests.AbstractRequestBuilder;
import discojx.utils.json.JsonUtils;
import discojx.utils.requests.RequestPathParametersConstructor;
import discojx.utils.requests.StringBuilderSequentialRequestPathParametersConstructor;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultMarketplaceGetListingRequest extends AbstractRequest
        implements MarketplaceGetListingRequest {

    public DefaultMarketplaceGetListingRequest(AbstractRequestBuilder builder) {
        super(builder);
    }

    public static class Builder extends AbstractPathParameterizedRequestBuilder<RequestPathParametersConstructor>
            implements MarketplaceGetListingRequestBuilder {

        private long listingId;
        private String currAbbr;

        public Builder(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public MarketplaceGetListingRequestBuilder listingId(long listingId) {
            this.listingId = listingId;
            return this;
        }

        @Override
        public MarketplaceGetListingRequestBuilder currAbbr(String currAbbr) {
            this.currAbbr = currAbbr;
            return this;
        }

        @Override
        public MarketplaceGetListingRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .MARKETPLACE_GET_LISTING
                    .getEndpointWith(constructPathParameters().toParametersString())
                    .replace("{listing_id}", String.valueOf(listingId));
            return new DefaultMarketplaceGetListingRequest(this);
        }

        @Override
        public RequestPathParametersConstructor constructPathParameters() {
            StringBuilderSequentialRequestPathParametersConstructor parameters =
                    new StringBuilderSequentialRequestPathParametersConstructor();

            if (currAbbr != null) parameters.append("curr_abbr", currAbbr);

            return parameters;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "listingId=" + listingId +
                    ", currAbbr=" + currAbbr +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Builder builder = (Builder) o;
            return listingId == builder.listingId && currAbbr.equals(builder.currAbbr);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), listingId, currAbbr);
        }
    }

    @Override
    public CompletableFuture<Listing> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            HttpResponse response = client.execute(new HttpGet(queryUrl));

            Listing listing;
            try {
                listing = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(response.getEntity().getContent(), Listing.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return listing;
        });
    }
}
