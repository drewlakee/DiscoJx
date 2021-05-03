package discojx.discogs.api.marketplace.order;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.marketplace.order.requests.edit.DefaultMarketplaceEditOrderRequest;
import discojx.discogs.api.marketplace.order.requests.edit.MarketplaceEditOrderRequestBuilder;
import discojx.discogs.api.marketplace.order.requests.get.DefaultMarketplaceGetOrderRequest;
import discojx.discogs.api.marketplace.order.requests.get.MarketplaceGetOrderRequestBuilder;
import discojx.discogs.api.marketplace.order.requests.list.DefaultMarketplaceListOrdersRequest;
import discojx.discogs.api.marketplace.order.requests.list.MarketplaceListOrdersRequestBuilder;

import java.util.Objects;

public class DefaultMarketplaceOrderApi implements MarketplaceOrderApi {

    protected final AbstractHttpClient client;

    public DefaultMarketplaceOrderApi(AbstractHttpClient client) {
        this.client = client;
    }

    @Override
    public MarketplaceGetOrderRequestBuilder get() {
        return new DefaultMarketplaceGetOrderRequest.Builder(client);
    }

    @Override
    public MarketplaceEditOrderRequestBuilder edit() {
        return new DefaultMarketplaceEditOrderRequest.Builder(client);
    }

    @Override
    public MarketplaceListOrdersRequestBuilder list() {
        return new DefaultMarketplaceListOrdersRequest.Builder(client);
    }

    @Override
    public String toString() {
        return "DefaultMarketplaceOrderApi{" +
                "client=" + client +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultMarketplaceOrderApi that = (DefaultMarketplaceOrderApi) o;
        return Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client);
    }
}
