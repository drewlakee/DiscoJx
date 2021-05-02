package discojx.discogs.api.marketplace.order.requests.edit;

import discojx.requests.RequestBuilder;

public interface MarketplaceEditOrderRequestBuilder extends RequestBuilder<MarketplaceEditOrderRequest> {

    MarketplaceEditOrderRequestBuilder orderId(String orderId);
    MarketplaceEditOrderRequestBuilder status(String status);
    MarketplaceEditOrderRequestBuilder shipping(double shipping);
}
