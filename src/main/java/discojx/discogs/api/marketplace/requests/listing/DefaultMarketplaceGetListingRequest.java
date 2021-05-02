package discojx.discogs.api.marketplace.requests.listing;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.Listing;
import discojx.discogs.objects.MarketplaceCurrency;
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

public class DefaultMarketplaceGetListingRequest extends AbstractRequest
        implements MarketplaceGetListingRequest {

    public DefaultMarketplaceGetListingRequest(AbstractRequestBuilder builder) {
        super(builder);
    }

    public static class BuilderGet extends AbstractPathParameterizedRequestBuilder<RequestPathParametersConstructor>
            implements MarketplaceGetListingRequestBuilder {

        private long listingId;
        private MarketplaceCurrency currAbbr;

        public BuilderGet(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public MarketplaceGetListingRequestBuilder listingId(long listingId) {
            this.listingId = listingId;
            return this;
        }

        @Override
        public MarketplaceGetListingRequestBuilder currAbbr(MarketplaceCurrency currAbbr) {
            this.currAbbr = currAbbr;
            return this;
        }

        @Override
        public MarketplaceGetListingRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .MARKETPLACE_INVENTORY
                    .getEndpointWith(constructPathParameters().toParametersString())
                    .replace("{listing_id}", String.valueOf(listingId));
            return new DefaultMarketplaceGetListingRequest(this);
        }

        @Override
        public RequestPathParametersConstructor constructPathParameters() {
            StringBuilderSequentialRequestPathParametersConstructor parameters =
                    new StringBuilderSequentialRequestPathParametersConstructor();

            if (currAbbr != null) parameters.append("curr_abbr", currAbbr.name());

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
            BuilderGet builder = (BuilderGet) o;
            return listingId == builder.listingId && currAbbr == builder.currAbbr;
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
