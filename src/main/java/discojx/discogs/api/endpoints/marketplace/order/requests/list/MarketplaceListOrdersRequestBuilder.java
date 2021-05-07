package discojx.discogs.api.endpoints.marketplace.order.requests.list;

import discojx.discogs.api.requests.PaginationableRequest;
import discojx.discogs.api.requests.RequestBuilder;
import discojx.discogs.api.requests.SortableRequest;

import java.util.Date;

public interface MarketplaceListOrdersRequestBuilder extends
        RequestBuilder<MarketplaceListOrdersRequest>,
        PaginationableRequest<MarketplaceListOrdersRequestBuilder>,
        SortableRequest<MarketplaceListOrdersRequestBuilder> {

    MarketplaceListOrdersRequestBuilder status(String status);
    MarketplaceListOrdersRequestBuilder createdAfter(Date createdAfter);
    MarketplaceListOrdersRequestBuilder createdBefore(Date createdBefore);
    MarketplaceListOrdersRequestBuilder archived(boolean archived);
}
