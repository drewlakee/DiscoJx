package discojx.discogs.api.endpoints.marketplace.listing.requests.get;

import discojx.discogs.api.requests.RequestBuilder;

public interface MarketplaceGetListingRequestBuilder
        extends RequestBuilder<MarketplaceGetListingRequest> {

    MarketplaceGetListingRequestBuilder listingId(long id);
    MarketplaceGetListingRequestBuilder currAbbr(String currAbbr);
}
