package discojx.discogs.api.marketplace.order.requests.messages;

import discojx.requests.PaginationableRequest;
import discojx.requests.RequestBuilder;

public interface MarketplaceListOrderMessagesRequestBuilder extends
        RequestBuilder<MarketplaceListOrderMessagesRequest>,
        PaginationableRequest<MarketplaceListOrderMessagesRequestBuilder> {

    MarketplaceListOrderMessagesRequestBuilder orderId(String orderId);
}
