package discojx.discogs.api.marketplace.listing;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.marketplace.listing.requests.delete.DefaultMarketplaceDeleteListingRequest;
import discojx.discogs.api.marketplace.listing.requests.delete.MarketplaceDeleteListingRequestBuilder;
import discojx.discogs.api.marketplace.listing.requests.edit.DefaultMarketplaceEditListingRequest;
import discojx.discogs.api.marketplace.listing.requests.edit.MarketplaceEditListingRequestBuilder;
import discojx.discogs.api.marketplace.listing.requests.get.DefaultMarketplaceGetListingRequest;
import discojx.discogs.api.marketplace.listing.requests.get.MarketplaceGetListingRequestBuilder;

import java.util.Objects;

public class DefaultMarketplaceListingApi implements MarketplaceListingApi {

    protected final AbstractHttpClient client;

    public DefaultMarketplaceListingApi(AbstractHttpClient client) {
        this.client = client;
    }

    @Override
    public MarketplaceGetListingRequestBuilder get() {
        return new DefaultMarketplaceGetListingRequest.Builder(client);
    }

    @Override
    public MarketplaceEditListingRequestBuilder edit() {
        return new DefaultMarketplaceEditListingRequest.Builder(client);
    }

    @Override
    public MarketplaceDeleteListingRequestBuilder delete() {
        return new DefaultMarketplaceDeleteListingRequest.Builder(client);
    }

    @Override
    public String toString() {
        return "DefaultMarketplaceListingApi{" +
                "client=" + client +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultMarketplaceListingApi that = (DefaultMarketplaceListingApi) o;
        return Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client);
    }
}
