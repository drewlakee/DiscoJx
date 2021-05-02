package discojx.discogs.api.marketplace;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.marketplace.inventory.DefaultMarketplaceInventoryApi;
import discojx.discogs.api.marketplace.inventory.MarketplaceInventoryApi;
import discojx.discogs.api.marketplace.listing.DefaultMarketplaceListingApi;
import discojx.discogs.api.marketplace.listing.MarketplaceListingApi;
import discojx.discogs.api.marketplace.order.DefaultMarketplaceOrderApi;
import discojx.discogs.api.marketplace.order.MarketplaceOrderApi;

import java.util.Objects;

public class DefaultMarketplaceApi implements MarketplaceApi {

    protected final MarketplaceInventoryApi marketplaceInventoryApi;
    protected final MarketplaceListingApi marketplaceListingApi;
    private final MarketplaceOrderApi marketplaceOrderApi;

    public DefaultMarketplaceApi(AbstractHttpClient client) {
        this.marketplaceInventoryApi = new DefaultMarketplaceInventoryApi(client);
        this.marketplaceListingApi = new DefaultMarketplaceListingApi(client);
        this.marketplaceOrderApi = new DefaultMarketplaceOrderApi(client);
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
    public MarketplaceOrderApi order() {
        return marketplaceOrderApi;
    }

    @Override
    public String toString() {
        return "DefaultMarketplaceApi{" +
                "marketplaceInventoryApi=" + marketplaceInventoryApi +
                ", marketplaceListingApi=" + marketplaceListingApi +
                ", marketplaceOrderApi=" + marketplaceOrderApi +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultMarketplaceApi that = (DefaultMarketplaceApi) o;
        return Objects.equals(marketplaceInventoryApi, that.marketplaceInventoryApi) && Objects.equals(marketplaceListingApi, that.marketplaceListingApi) && Objects.equals(marketplaceOrderApi, that.marketplaceOrderApi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marketplaceInventoryApi, marketplaceListingApi, marketplaceOrderApi);
    }
}
