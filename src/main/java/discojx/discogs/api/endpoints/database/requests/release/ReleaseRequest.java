package discojx.discogs.api.endpoints.database.requests.release;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface ReleaseRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
