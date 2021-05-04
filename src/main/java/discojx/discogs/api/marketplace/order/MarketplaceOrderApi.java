package discojx.discogs.api.marketplace.order;

import discojx.discogs.api.marketplace.order.requests.edit.MarketplaceEditOrderRequestBuilder;
import discojx.discogs.api.marketplace.order.requests.get.MarketplaceGetOrderRequestBuilder;
import discojx.discogs.api.marketplace.order.requests.list.MarketplaceListOrdersRequestBuilder;
import discojx.discogs.api.marketplace.order.requests.messages.MarketplaceListOrderMessagesRequestBuilder;

public interface MarketplaceOrderApi {

    MarketplaceGetOrderRequestBuilder getOrder();
    MarketplaceEditOrderRequestBuilder editOrder();
    MarketplaceListOrdersRequestBuilder ordersList();
    MarketplaceListOrderMessagesRequestBuilder getOrderMessages();
}
