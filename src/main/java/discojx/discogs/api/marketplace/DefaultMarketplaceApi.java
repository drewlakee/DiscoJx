package discojx.discogs.api.marketplace;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.marketplace.requests.inventory.DefaultMarketplaceInventoryRequest;
import discojx.discogs.api.marketplace.requests.inventory.MarketplaceInventoryRequestBuilder;
import discojx.discogs.api.marketplace.requests.listing.delete.DefaultMarketplaceDeleteListingRequest;
import discojx.discogs.api.marketplace.requests.listing.delete.MarketplaceDeleteListingRequestBuilder;
import discojx.discogs.api.marketplace.requests.listing.edit.DefaultMarketplaceEditListingRequest;
import discojx.discogs.api.marketplace.requests.listing.edit.MarketplaceEditListingRequestBuilder;
import discojx.discogs.api.marketplace.requests.listing.get.DefaultMarketplaceGetListingRequest;
import discojx.discogs.api.marketplace.requests.listing.get.MarketplaceGetListingRequestBuilder;

import java.util.Objects;

public class DefaultMarketplaceApi implements MarketplaceApi{

    protected final AbstractHttpClient client;

    public DefaultMarketplaceApi(AbstractHttpClient client) {
        this.client = client;
    }

    @Override
    public MarketplaceInventoryRequestBuilder inventory() {
        return new DefaultMarketplaceInventoryRequest.Builder(client);
    }

    @Override
    public MarketplaceGetListingRequestBuilder getListing() {
        return new DefaultMarketplaceGetListingRequest.Builder(client);
    }

    @Override
    public MarketplaceEditListingRequestBuilder editListing() {
        return new DefaultMarketplaceEditListingRequest.Builder(client);
    }

    @Override
    public MarketplaceDeleteListingRequestBuilder deleteListing() {
        return new DefaultMarketplaceDeleteListingRequest.Builder(client);
    }

    @Override
    public String toString() {
        return "DefaultMarketplaceApi{" +
                "client=" + client +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultMarketplaceApi that = (DefaultMarketplaceApi) o;
        return Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client);
    }
}
