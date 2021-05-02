package discojx.discogs.api.marketplace;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.marketplace.inventory.DefaultMarketplaceInventoryApi;
import discojx.discogs.api.marketplace.inventory.MarketplaceInventoryApi;
import discojx.discogs.api.marketplace.listing.DefaultMarketplaceListingApi;
import discojx.discogs.api.marketplace.listing.MarketplaceListingApi;

import java.util.Objects;

public class DefaultMarketplaceApi implements MarketplaceApi {

    protected final MarketplaceInventoryApi marketplaceInventoryApi;
    protected final MarketplaceListingApi marketplaceListingApi;

    public DefaultMarketplaceApi(AbstractHttpClient client) {
        this.marketplaceInventoryApi = new DefaultMarketplaceInventoryApi(client);
        this.marketplaceListingApi = new DefaultMarketplaceListingApi(client);
    }

    @Override
    public MarketplaceInventoryApi inventory() {
        return marketplaceInventoryApi;
    }

    @Override
    public MarketplaceListingApi listing() {
        return marketplaceListingApi;
    }

    @Override
    public String toString() {
        return "DefaultMarketplaceApi{" +
                "marketplaceInventoryApi=" + marketplaceInventoryApi +
                ", marketplaceListingApi=" + marketplaceListingApi +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultMarketplaceApi that = (DefaultMarketplaceApi) o;
        return Objects.equals(marketplaceInventoryApi, that.marketplaceInventoryApi) && Objects.equals(marketplaceListingApi, that.marketplaceListingApi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marketplaceInventoryApi, marketplaceListingApi);
    }
}
