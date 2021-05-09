package discojx.discogs.api.endpoints.marketplace.order.requests.list;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface MarketplaceListOrdersRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
