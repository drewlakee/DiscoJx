package discojx.discogs.api.endpoints.marketplace.order;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.requests.impl.DefaultMarketplaceEditOrderRequest;
import discojx.discogs.api.endpoints.marketplace.order.requests.edit.MarketplaceEditOrderRequestBuilder;
import discojx.discogs.api.requests.impl.DefaultMarketplaceGetOrderRequest;
import discojx.discogs.api.endpoints.marketplace.order.requests.get.MarketplaceGetOrderRequestBuilder;
import discojx.discogs.api.requests.impl.DefaultMarketplaceListOrdersRequest;
import discojx.discogs.api.endpoints.marketplace.order.requests.list.MarketplaceListOrdersRequestBuilder;
import discojx.discogs.api.requests.impl.DefaultMarketplaceAddNewOrderMessageRequest;
import discojx.discogs.api.endpoints.marketplace.order.requests.messages.add.MarketplaceAddNewOrderMessageRequestBuilder;
import discojx.discogs.api.requests.impl.DefaultMarketplaceListOrderMessagesRequest;
import discojx.discogs.api.endpoints.marketplace.order.requests.messages.get.MarketplaceListOrderMessagesRequestBuilder;

import java.util.Objects;

public class DefaultMarketplaceOrderApi implements MarketplaceOrderApi {

    protected final AbstractHttpClient client;

    public DefaultMarketplaceOrderApi(AbstractHttpClient client) {
        this.client = client;
    }

    @Override
    public MarketplaceGetOrderRequestBuilder getOrder() {
        return new DefaultMarketplaceGetOrderRequest.Builder(client);
    }

    @Override
    public MarketplaceEditOrderRequestBuilder editOrder() {
        return new DefaultMarketplaceEditOrderRequest.Builder(client);
    }

    @Override
    public MarketplaceListOrdersRequestBuilder ordersList() {
        return new DefaultMarketplaceListOrdersRequest.Builder(client);
    }

    @Override
    public MarketplaceListOrderMessagesRequestBuilder getOrderMessages() {
        return new DefaultMarketplaceListOrderMessagesRequest.Builder(client);
    }

    @Override
    public MarketplaceAddNewOrderMessageRequestBuilder addNewOrderMessage() {
        return new DefaultMarketplaceAddNewOrderMessageRequest.Builder(client);
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
