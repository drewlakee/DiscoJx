package discojx.discogs.api.marketplace.order.requests.get;

import discojx.requests.RequestBuilder;

public interface MarketplaceGetOrderRequestBuilder extends RequestBuilder<MarketplaceGetOrderRequest> {

    MarketplaceGetOrderRequestBuilder orderId(String orderId);
}
