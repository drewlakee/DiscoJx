package discojx.discogs.api.endpoints.marketplace.order.requests.messages.add;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.OrderMessage;

public interface MarketplaceAddNewOrderMessageRequest extends AsyncExecutableRequest<EntityResponseWrapper<OrderMessage>> {
}
