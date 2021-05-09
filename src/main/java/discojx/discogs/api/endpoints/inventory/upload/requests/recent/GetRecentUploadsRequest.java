package discojx.discogs.api.endpoints.inventory.upload.requests.recent;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface GetRecentUploadsRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
