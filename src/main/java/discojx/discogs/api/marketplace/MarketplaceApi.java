package discojx.discogs.api.marketplace;

import discojx.discogs.api.marketplace.requests.inventory.MarketplaceInventoryRequestBuilder;
import discojx.discogs.api.marketplace.requests.listing.MarketplaceGetListingRequestBuilder;

public interface MarketplaceApi {

    MarketplaceInventoryRequestBuilder inventory();
    MarketplaceGetListingRequestBuilder getListing();
}
