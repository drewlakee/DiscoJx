package discojx.discogs.api.marketplace.listing;

import discojx.discogs.api.marketplace.listing.requests.delete.MarketplaceDeleteListingRequestBuilder;
import discojx.discogs.api.marketplace.listing.requests.edit.MarketplaceEditListingRequestBuilder;
import discojx.discogs.api.marketplace.listing.requests.get.MarketplaceGetListingRequestBuilder;

public interface MarketplaceListingApi {

    MarketplaceGetListingRequestBuilder get();
    MarketplaceEditListingRequestBuilder edit();
    MarketplaceDeleteListingRequestBuilder delete();
}
