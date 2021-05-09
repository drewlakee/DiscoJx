package discojx.discogs.api.endpoints.database.requests.search;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface SearchRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
