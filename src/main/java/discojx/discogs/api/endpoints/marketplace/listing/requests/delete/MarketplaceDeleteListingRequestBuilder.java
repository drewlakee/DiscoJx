package discojx.discogs.api.endpoints.marketplace.listing.requests.delete;

import discojx.discogs.api.requests.RequestBuilder;

public interface MarketplaceDeleteListingRequestBuilder extends RequestBuilder<MarketplaceDeleteListingRequest> {

    MarketplaceDeleteListingRequestBuilder listingId(long listingId);
}
