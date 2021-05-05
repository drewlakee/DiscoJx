package discojx.discogs.api.endpoints.marketplace.inventory;

import discojx.discogs.api.endpoints.marketplace.inventory.requests.MarketplaceInventoryRequestBuilder;

public interface MarketplaceInventoryApi {

    MarketplaceInventoryRequestBuilder getMarketplaceInventory();
}
