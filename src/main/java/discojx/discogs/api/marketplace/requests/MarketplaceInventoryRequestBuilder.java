package discojx.discogs.api.marketplace.requests;

import discojx.requests.PaginationableRequest;
import discojx.requests.RequestBuilder;
import discojx.requests.SortableRequest;

public interface MarketplaceInventoryRequestBuilder extends
        RequestBuilder<MarketplaceInventoryRequest>,
        PaginationableRequest<MarketplaceInventoryRequestBuilder>,
        SortableRequest<MarketplaceInventoryRequestBuilder> {

    MarketplaceInventoryRequestBuilder username(String username);
    MarketplaceInventoryRequestBuilder status(String status);
}
