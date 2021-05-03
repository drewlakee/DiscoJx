package discojx.discogs.api.marketplace.order.requests.list;

import discojx.requests.PaginationableRequest;
import discojx.requests.RequestBuilder;
import discojx.requests.SortableRequest;

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
