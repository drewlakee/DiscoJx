package discojx.discogs.api.marketplace.order;

import discojx.discogs.api.marketplace.order.requests.edit.MarketplaceEditOrderRequestBuilder;
import discojx.discogs.api.marketplace.order.requests.get.MarketplaceGetOrderRequestBuilder;
import discojx.discogs.api.marketplace.order.requests.list.MarketplaceListOrdersRequestBuilder;

public interface MarketplaceOrderApi {

    MarketplaceGetOrderRequestBuilder get();
    MarketplaceEditOrderRequestBuilder edit();
    MarketplaceListOrdersRequestBuilder list();
}
