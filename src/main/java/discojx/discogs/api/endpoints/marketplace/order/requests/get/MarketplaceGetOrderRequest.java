package discojx.discogs.api.endpoints.marketplace.order.requests.get;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.MarketplaceOrder;

public interface MarketplaceGetOrderRequest extends AsyncExecutableRequest<EntityResponseWrapper<MarketplaceOrder>> {
}
