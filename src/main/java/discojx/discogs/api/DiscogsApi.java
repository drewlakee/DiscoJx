package discojx.discogs.api;

import discojx.discogs.api.endpoints.database.DatabaseApi;
import discojx.discogs.api.endpoints.inventory.InventoryApi;
import discojx.discogs.api.endpoints.marketplace.MarketplaceApi;
import discojx.discogs.api.endpoints.user.UserApi;

public interface DiscogsApi {

    UserApi user();
    DatabaseApi database();
    InventoryApi inventory();
    MarketplaceApi marketplace();
}
