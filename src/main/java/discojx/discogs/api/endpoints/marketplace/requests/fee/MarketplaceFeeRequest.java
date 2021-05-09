package discojx.discogs.api.endpoints.marketplace.requests.fee;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface MarketplaceFeeRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
