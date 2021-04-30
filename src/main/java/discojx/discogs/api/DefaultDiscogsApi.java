package discojx.discogs.api;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.database.DatabaseApi;
import discojx.discogs.api.database.DefaultDatabaseApi;
import discojx.discogs.api.inventory.DefaultInventoryApi;
import discojx.discogs.api.inventory.InventoryApi;
import discojx.discogs.api.user.DefaultUserApi;
import discojx.discogs.api.user.UserApi;

import java.util.Objects;

public class DefaultDiscogsApi implements DiscogsApi {

    protected final UserApi userApi;
    protected final DatabaseApi databaseApi;
    protected final InventoryApi inventoryApi;

    public DefaultDiscogsApi(AbstractHttpClient client) {
        this.userApi = new DefaultUserApi(client);
        this.databaseApi = new DefaultDatabaseApi(client);
        this.inventoryApi = new DefaultInventoryApi(client);
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
    public String toString() {
        return "DefaultDiscogsApi{" +
                "userApi=" + userApi +
                ", databaseApi=" + databaseApi +
                ", inventoryApi=" + inventoryApi +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultDiscogsApi that = (DefaultDiscogsApi) o;
        return Objects.equals(userApi, that.userApi) && Objects.equals(databaseApi, that.databaseApi) && Objects.equals(inventoryApi, that.inventoryApi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userApi, databaseApi, inventoryApi);
    }
}
