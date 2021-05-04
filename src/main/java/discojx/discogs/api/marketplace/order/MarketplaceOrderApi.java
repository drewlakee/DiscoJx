package discojx.discogs.api.marketplace.order;

import discojx.discogs.api.marketplace.order.requests.edit.MarketplaceEditOrderRequestBuilder;
import discojx.discogs.api.marketplace.order.requests.get.MarketplaceGetOrderRequestBuilder;
import discojx.discogs.api.marketplace.order.requests.list.MarketplaceListOrdersRequestBuilder;
import discojx.discogs.api.marketplace.order.requests.messages.add.MarketplaceAddNewOrderMessageRequestBuilder;
import discojx.discogs.api.marketplace.order.requests.messages.get.MarketplaceListOrderMessagesRequestBuilder;

public interface MarketplaceOrderApi {

    MarketplaceGetOrderRequestBuilder getOrder();
    MarketplaceEditOrderRequestBuilder editOrder();
    MarketplaceListOrdersRequestBuilder ordersList();
    MarketplaceListOrderMessagesRequestBuilder getOrderMessages();
    MarketplaceAddNewOrderMessageRequestBuilder addNewOrderMessage();
}
