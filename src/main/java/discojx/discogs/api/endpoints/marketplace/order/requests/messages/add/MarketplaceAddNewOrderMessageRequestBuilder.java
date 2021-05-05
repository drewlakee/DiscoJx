package discojx.discogs.api.endpoints.marketplace.order.requests.messages.add;

import discojx.discogs.api.requests.RequestBuilder;

public interface MarketplaceAddNewOrderMessageRequestBuilder extends RequestBuilder<MarketplaceAddNewOrderMessageRequest> {

    MarketplaceAddNewOrderMessageRequestBuilder orderId(String orderId);
    MarketplaceAddNewOrderMessageRequestBuilder message(String message);
    MarketplaceAddNewOrderMessageRequestBuilder status(String status);
}
