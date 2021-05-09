package discojx.discogs.api.endpoints.database.requests.release.master;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface MasterReleaseRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
