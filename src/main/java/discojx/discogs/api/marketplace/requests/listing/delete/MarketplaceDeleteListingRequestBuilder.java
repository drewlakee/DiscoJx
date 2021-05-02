package discojx.discogs.api.marketplace.requests.listing.delete;

import discojx.requests.RequestBuilder;

public interface MarketplaceDeleteListingRequestBuilder extends RequestBuilder<MarketplaceDeleteListingRequest> {

    MarketplaceDeleteListingRequestBuilder listingId(long listingId);
}
