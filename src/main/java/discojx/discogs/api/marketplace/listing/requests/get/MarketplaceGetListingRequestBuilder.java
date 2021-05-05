package discojx.discogs.api.marketplace.listing.requests.get;

import discojx.requests.RequestBuilder;

public interface MarketplaceGetListingRequestBuilder
        extends RequestBuilder<MarketplaceGetListingRequest> {

    MarketplaceGetListingRequestBuilder listingId(long id);
    MarketplaceGetListingRequestBuilder currAbbr(String currAbbr);
}
