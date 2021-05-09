package discojx.discogs.api.endpoints.database.requests.release.stats;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface ReleaseStatsRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
