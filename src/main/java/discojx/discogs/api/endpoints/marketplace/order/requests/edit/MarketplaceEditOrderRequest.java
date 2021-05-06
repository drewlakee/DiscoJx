package discojx.discogs.api.endpoints.marketplace.order.requests.edit;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.MarketplaceOrder;

public interface MarketplaceEditOrderRequest extends AsyncExecutableRequest<EntityResponseWrapper<MarketplaceOrder>> {
}
