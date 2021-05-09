package discojx.discogs.api.endpoints.inventory.export.requests.recent;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface GetRecentExportsRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
