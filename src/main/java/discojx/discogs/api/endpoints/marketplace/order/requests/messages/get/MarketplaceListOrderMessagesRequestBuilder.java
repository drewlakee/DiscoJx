package discojx.discogs.api.endpoints.marketplace.order.requests.messages.get;

import discojx.discogs.api.requests.PaginationableRequest;
import discojx.discogs.api.requests.RequestBuilder;

public interface MarketplaceListOrderMessagesRequestBuilder extends
        RequestBuilder<MarketplaceListOrderMessagesRequest>,
        PaginationableRequest<MarketplaceListOrderMessagesRequestBuilder> {

    MarketplaceListOrderMessagesRequestBuilder orderId(String orderId);
}
