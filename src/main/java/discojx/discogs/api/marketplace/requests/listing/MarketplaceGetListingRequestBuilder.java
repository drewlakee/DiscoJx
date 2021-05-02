package discojx.discogs.api.marketplace.requests.listing;

import discojx.discogs.objects.MarketplaceCurrency;
import discojx.requests.RequestBuilder;

public interface MarketplaceGetListingRequestBuilder
        extends RequestBuilder<MarketplaceGetListingRequest> {

    MarketplaceGetListingRequestBuilder listingId(long id);
    MarketplaceGetListingRequestBuilder currAbbr(MarketplaceCurrency currAbbr);
}
