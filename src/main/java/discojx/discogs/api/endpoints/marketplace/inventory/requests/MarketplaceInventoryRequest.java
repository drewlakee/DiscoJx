package discojx.discogs.api.endpoints.marketplace.inventory.requests;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface MarketplaceInventoryRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
