package discojx.discogs.api.marketplace;

import discojx.discogs.api.marketplace.inventory.MarketplaceInventoryApi;
import discojx.discogs.api.marketplace.listing.MarketplaceListingApi;

public interface MarketplaceApi {

    MarketplaceInventoryApi inventory();
    MarketplaceListingApi listing();
}
