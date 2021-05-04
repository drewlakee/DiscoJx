package discojx.discogs.api.marketplace.order.requests.messages.add;

import discojx.requests.RequestBuilder;

public interface MarketplaceAddNewOrderMessageRequestBuilder extends RequestBuilder<MarketplaceAddNewOrderMessageRequest> {

    MarketplaceAddNewOrderMessageRequestBuilder orderId(String orderId);
    MarketplaceAddNewOrderMessageRequestBuilder message(String message);
    MarketplaceAddNewOrderMessageRequestBuilder status(String status);
}
