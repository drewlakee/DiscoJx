package discojx.discogs.api.endpoints.marketplace.listing;

import discojx.discogs.api.endpoints.marketplace.listing.requests.create.MarketplaceNewListingRequestBuilder;
import discojx.discogs.api.endpoints.marketplace.listing.requests.delete.MarketplaceDeleteListingRequestBuilder;
import discojx.discogs.api.endpoints.marketplace.listing.requests.edit.MarketplaceEditListingRequestBuilder;
import discojx.discogs.api.endpoints.marketplace.listing.requests.get.MarketplaceGetListingRequestBuilder;

public interface MarketplaceListingApi {

    MarketplaceGetListingRequestBuilder getListing();
    MarketplaceEditListingRequestBuilder editListing();
    MarketplaceDeleteListingRequestBuilder deleteListing();
    MarketplaceNewListingRequestBuilder newListing();
}
