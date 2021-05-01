package discojx.discogs.api.marketplace;

import discojx.discogs.api.marketplace.requests.MarketplaceInventoryRequestBuilder;

public interface MarketplaceApi {

    MarketplaceInventoryRequestBuilder inventory();
}
