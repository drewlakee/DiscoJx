package discojx.discogs.api.endpoints.marketplace.order.requests.messages.get;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.requests.ListOrderMessages;

public interface MarketplaceListOrderMessagesRequest extends AsyncExecutableRequest<EntityResponseWrapper<ListOrderMessages>> {
}
