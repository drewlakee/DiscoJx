package discojx.discogs.api.marketplace;

import discojx.discogs.api.marketplace.requests.inventory.MarketplaceInventoryRequestBuilder;
import discojx.discogs.api.marketplace.requests.listing.delete.MarketplaceDeleteListingRequestBuilder;
import discojx.discogs.api.marketplace.requests.listing.edit.MarketplaceEditListingRequestBuilder;
import discojx.discogs.api.marketplace.requests.listing.get.MarketplaceGetListingRequestBuilder;

public interface MarketplaceApi {

    MarketplaceInventoryRequestBuilder inventory();
    MarketplaceGetListingRequestBuilder getListing();
    MarketplaceEditListingRequestBuilder editListing();
    MarketplaceDeleteListingRequestBuilder deleteListing();
}
