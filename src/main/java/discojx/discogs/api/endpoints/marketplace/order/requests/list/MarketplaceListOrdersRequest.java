package discojx.discogs.api.endpoints.marketplace.order.requests.list;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.requests.MarketplaceListOrders;

public interface MarketplaceListOrdersRequest extends AsyncExecutableRequest<EntityResponseWrapper<MarketplaceListOrders>> {
}
