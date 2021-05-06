package discojx.discogs.api.endpoints.marketplace.order.requests.get;

import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.MarketplaceOrder;
import discojx.discogs.api.requests.AsyncExecutableRequest;

public interface MarketplaceGetOrderRequest extends AsyncExecutableRequest<EntityResponseWrapper<MarketplaceOrder>> {
}
