package discojx.discogs.api;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.endpoints.database.DatabaseApi;
import discojx.discogs.api.endpoints.database.DefaultDatabaseApi;
import discojx.discogs.api.endpoints.inventory.DefaultInventoryApi;
import discojx.discogs.api.endpoints.inventory.InventoryApi;
import discojx.discogs.api.endpoints.marketplace.DefaultMarketplaceApi;
import discojx.discogs.api.endpoints.marketplace.MarketplaceApi;
import discojx.discogs.api.endpoints.user.DefaultUserApi;
import discojx.discogs.api.endpoints.user.UserApi;

import java.util.Objects;

public class DefaultDiscogsApi implements DiscogsApi {

    protected final UserApi userApi;
    protected final DatabaseApi databaseApi;
    protected final InventoryApi inventoryApi;
    protected final MarketplaceApi marketplaceApi;

    public DefaultDiscogsApi(AbstractHttpClient client) {
        this.userApi = new DefaultUserApi(client);
        this.databaseApi = new DefaultDatabaseApi(client);
        this.inventoryApi = new DefaultInventoryApi(client);
        this.marketplaceApi = new DefaultMarketplaceApi(client);
    }

    @Override
    public UserApi user() {
        return userApi;
    }

    @Override
    public DatabaseApi database() {
        return databaseApi;
    }

    @Override
    public InventoryApi inventory() {
        return inventoryApi;
    }

    @Override
    public MarketplaceApi marketplace() {
        return marketplaceApi;
    }

    @Override
    public String toString() {
        return "DefaultDiscogsApi{" +
                "userApi=" + userApi +
                ", databaseApi=" + databaseApi +
                ", inventoryApi=" + inventoryApi +
                ", marketplaceApi=" + marketplaceApi +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultDiscogsApi that = (DefaultDiscogsApi) o;
        return Objects.equals(userApi, that.userApi) && Objects.equals(databaseApi, that.databaseApi) && Objects.equals(inventoryApi, that.inventoryApi) && Objects.equals(marketplaceApi, that.marketplaceApi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userApi, databaseApi, inventoryApi, marketplaceApi);
    }
}
