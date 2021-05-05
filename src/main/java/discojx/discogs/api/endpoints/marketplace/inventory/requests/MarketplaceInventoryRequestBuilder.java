package discojx.discogs.api.endpoints.marketplace.inventory.requests;

import discojx.discogs.api.requests.PaginationableRequest;
import discojx.discogs.api.requests.RequestBuilder;
import discojx.discogs.api.requests.SortableRequest;

public interface MarketplaceInventoryRequestBuilder extends
        RequestBuilder<MarketplaceInventoryRequest>,
        PaginationableRequest<MarketplaceInventoryRequestBuilder>,
        SortableRequest<MarketplaceInventoryRequestBuilder> {

    MarketplaceInventoryRequestBuilder username(String username);
    MarketplaceInventoryRequestBuilder status(String status);
}
