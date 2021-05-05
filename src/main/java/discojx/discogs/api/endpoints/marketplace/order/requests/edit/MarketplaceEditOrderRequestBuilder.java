package discojx.discogs.api.endpoints.marketplace.order.requests.edit;

import discojx.discogs.api.requests.RequestBuilder;

public interface MarketplaceEditOrderRequestBuilder extends RequestBuilder<MarketplaceEditOrderRequest> {

    MarketplaceEditOrderRequestBuilder orderId(String orderId);
    MarketplaceEditOrderRequestBuilder status(String status);
    MarketplaceEditOrderRequestBuilder shipping(double shipping);
}
