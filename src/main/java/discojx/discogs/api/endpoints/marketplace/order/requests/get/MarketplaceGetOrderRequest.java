package discojx.discogs.api.endpoints.marketplace.order.requests.get;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface MarketplaceGetOrderRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
