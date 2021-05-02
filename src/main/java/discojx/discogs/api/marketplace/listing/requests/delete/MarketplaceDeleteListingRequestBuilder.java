package discojx.discogs.api.marketplace.listing.requests.delete;

import discojx.requests.RequestBuilder;

public interface MarketplaceDeleteListingRequestBuilder extends RequestBuilder<MarketplaceDeleteListingRequest> {

    MarketplaceDeleteListingRequestBuilder listingId(long listingId);
}
