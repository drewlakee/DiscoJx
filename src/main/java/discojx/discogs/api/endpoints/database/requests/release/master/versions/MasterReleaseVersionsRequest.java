package discojx.discogs.api.endpoints.database.requests.release.master.versions;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface MasterReleaseVersionsRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
