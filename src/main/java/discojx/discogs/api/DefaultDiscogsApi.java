package discojx.discogs.api;

import discojx.http.AbstractHttpClient;
import discojx.http.DefaultLazyHttpClient;
import discojx.discogs.api.endpoints.database.DatabaseApi;
import discojx.discogs.api.endpoints.database.DefaultDatabaseApi;
import discojx.discogs.api.endpoints.inventory.DefaultInventoryApi;
import discojx.discogs.api.endpoints.inventory.InventoryApi;
import discojx.discogs.api.endpoints.marketplace.DefaultMarketplaceApi;
import discojx.discogs.api.endpoints.marketplace.MarketplaceApi;
import discojx.discogs.api.endpoints.user.DefaultUserApi;
import discojx.discogs.api.endpoints.user.UserApi;
import org.apache.http.Header;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DefaultDiscogsApi implements DiscogsApi {

    protected final UserApi userApi;
    protected final DatabaseApi databaseApi;
    protected final InventoryApi inventoryApi;
    protected final MarketplaceApi marketplaceApi;

    public DefaultDiscogsApi(Builder builder) {
        this.userApi = new DefaultUserApi(builder.client);
        this.databaseApi = new DefaultDatabaseApi(builder.client);
        this.inventoryApi = new DefaultInventoryApi(builder.client);
        this.marketplaceApi = new DefaultMarketplaceApi(builder.client);
    }

    public static class Builder {

        private AbstractHttpClient client;
        private List<Header> headers;
        private String token;

        private final boolean[] sets = new boolean[2];

        public Builder setPersonalAccessToken(String token) {
            this.token = token;
            sets[0] = token != null;
            return this;
        }

        public Builder setCustomDefaultRequestHeaders(List<Header> headers) {
            this.headers = headers;
            sets[1] = headers != null;
            return this;
        }

        public DiscogsApi build() {
            if (!sets[0] && !sets[1]) {
                client = new DefaultLazyHttpClient();
            }

            if (sets[0] && !sets[1]) {
                client = new DefaultLazyHttpClient(token);
            }

            if (!sets[0] && sets[1]) {
                client = new DefaultLazyHttpClient(headers);
            }

            if (sets[0] && sets[1]) {
                client = new DefaultLazyHttpClient(token, headers);
            }

            return new DefaultDiscogsApi(this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return Objects.equals(client, builder.client) && Objects.equals(headers, builder.headers) && Objects.equals(token, builder.token) && Arrays.equals(sets, builder.sets);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(client, headers, token);
            result = 31 * result + Arrays.hashCode(sets);
            return result;
        }
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
