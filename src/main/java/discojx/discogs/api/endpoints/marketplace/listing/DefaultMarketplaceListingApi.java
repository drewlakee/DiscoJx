package discojx.discogs.api.endpoints.marketplace.listing;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.requests.impl.DefaultMarketplaceNewListingRequest;
import discojx.discogs.api.endpoints.marketplace.listing.requests.create.MarketplaceNewListingRequestBuilder;
import discojx.discogs.api.requests.impl.DefaultMarketplaceDeleteListingRequest;
import discojx.discogs.api.endpoints.marketplace.listing.requests.delete.MarketplaceDeleteListingRequestBuilder;
import discojx.discogs.api.requests.impl.DefaultMarketplaceEditListingRequest;
import discojx.discogs.api.endpoints.marketplace.listing.requests.edit.MarketplaceEditListingRequestBuilder;
import discojx.discogs.api.requests.impl.DefaultMarketplaceGetListingRequest;
import discojx.discogs.api.endpoints.marketplace.listing.requests.get.MarketplaceGetListingRequestBuilder;

import java.util.Objects;

public class DefaultMarketplaceListingApi implements MarketplaceListingApi {

    protected final AbstractHttpClient client;

    public DefaultMarketplaceListingApi(AbstractHttpClient client) {
        this.client = client;
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
    public MarketplaceNewListingRequestBuilder newListing() {
        return new DefaultMarketplaceNewListingRequest.Builder(client);
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
