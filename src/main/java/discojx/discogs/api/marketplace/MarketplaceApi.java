package discojx.discogs.api.marketplace;

import discojx.discogs.api.marketplace.inventory.MarketplaceInventoryApi;
import discojx.discogs.api.marketplace.listing.MarketplaceListingApi;
import discojx.discogs.api.marketplace.order.MarketplaceOrderApi;

public interface MarketplaceApi {

    MarketplaceInventoryApi inventory();
    MarketplaceListingApi listing();
    MarketplaceOrderApi order();
}
