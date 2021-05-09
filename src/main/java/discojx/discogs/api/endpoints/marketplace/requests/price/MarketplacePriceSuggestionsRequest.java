package discojx.discogs.api.endpoints.marketplace.requests.price;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface MarketplacePriceSuggestionsRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
