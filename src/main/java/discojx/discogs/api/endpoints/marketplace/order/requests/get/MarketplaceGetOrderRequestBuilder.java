package discojx.discogs.api.endpoints.marketplace.order.requests.get;

import discojx.discogs.api.requests.RequestBuilder;

public interface MarketplaceGetOrderRequestBuilder extends RequestBuilder<MarketplaceGetOrderRequest> {

    MarketplaceGetOrderRequestBuilder orderId(String orderId);
}
