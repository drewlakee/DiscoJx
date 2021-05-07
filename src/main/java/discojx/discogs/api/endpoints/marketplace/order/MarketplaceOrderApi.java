package discojx.discogs.api.endpoints.marketplace.order;

import discojx.discogs.api.endpoints.marketplace.order.requests.edit.MarketplaceEditOrderRequestBuilder;
import discojx.discogs.api.endpoints.marketplace.order.requests.get.MarketplaceGetOrderRequestBuilder;
import discojx.discogs.api.endpoints.marketplace.order.requests.list.MarketplaceListOrdersRequestBuilder;
import discojx.discogs.api.endpoints.marketplace.order.requests.messages.add.MarketplaceAddNewOrderMessageRequestBuilder;
import discojx.discogs.api.endpoints.marketplace.order.requests.messages.get.MarketplaceListOrderMessagesRequestBuilder;

public interface MarketplaceOrderApi {

    MarketplaceGetOrderRequestBuilder getOrder();
    MarketplaceEditOrderRequestBuilder editOrder();
    MarketplaceListOrdersRequestBuilder ordersList();
    MarketplaceListOrderMessagesRequestBuilder getOrderMessages();
    MarketplaceAddNewOrderMessageRequestBuilder addNewOrderMessage();
}
