package discojx.discogs.api.endpoints.marketplace.order.requests.edit;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface MarketplaceEditOrderRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
