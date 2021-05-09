package discojx.discogs.api.endpoints.inventory.export.requests.get;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface GetExportRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
