package discojx.discogs.api.endpoints.marketplace.order.requests.messages.add;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface MarketplaceAddNewOrderMessageRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
