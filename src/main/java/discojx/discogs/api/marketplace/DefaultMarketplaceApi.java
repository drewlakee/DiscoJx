package discojx.discogs.api.marketplace;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.marketplace.inventory.DefaultMarketplaceInventoryApi;
import discojx.discogs.api.marketplace.inventory.MarketplaceInventoryApi;
import discojx.discogs.api.marketplace.listing.DefaultMarketplaceListingApi;
import discojx.discogs.api.marketplace.listing.MarketplaceListingApi;
import discojx.discogs.api.marketplace.order.DefaultMarketplaceOrderApi;
import discojx.discogs.api.marketplace.order.MarketplaceOrderApi;
import discojx.discogs.api.marketplace.requests.fee.DefaultMarketplaceFeeRequest;
import discojx.discogs.api.marketplace.requests.fee.MarketplaceFeeRequestBuilder;
import discojx.discogs.api.marketplace.requests.fee.currency.DefaultMarketplaceFeeWithCurrencyRequest;
import discojx.discogs.api.marketplace.requests.fee.currency.MarketplaceFeeWithCurrencyRequestBuilder;

import java.util.Objects;

public class DefaultMarketplaceApi implements MarketplaceApi {

    protected AbstractHttpClient client;

    protected final MarketplaceInventoryApi marketplaceInventoryApi;
    protected final MarketplaceListingApi marketplaceListingApi;
    protected final MarketplaceOrderApi marketplaceOrderApi;

    public DefaultMarketplaceApi(AbstractHttpClient client) {
        this.client = client;
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
    public MarketplaceFeeRequestBuilder fee() {
        return new DefaultMarketplaceFeeRequest.Builder(client);
    }

    @Override
    public MarketplaceFeeWithCurrencyRequestBuilder feeWithCurrency() {
        return new DefaultMarketplaceFeeWithCurrencyRequest.Builder(client);
    }

    @Override
    public String toString() {
        return "DefaultMarketplaceApi{" +
                "client=" + client +
                ", marketplaceInventoryApi=" + marketplaceInventoryApi +
                ", marketplaceListingApi=" + marketplaceListingApi +
                ", marketplaceOrderApi=" + marketplaceOrderApi +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultMarketplaceApi that = (DefaultMarketplaceApi) o;
        return Objects.equals(client, that.client) && Objects.equals(marketplaceInventoryApi, that.marketplaceInventoryApi) && Objects.equals(marketplaceListingApi, that.marketplaceListingApi) && Objects.equals(marketplaceOrderApi, that.marketplaceOrderApi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, marketplaceInventoryApi, marketplaceListingApi, marketplaceOrderApi);
    }
}
