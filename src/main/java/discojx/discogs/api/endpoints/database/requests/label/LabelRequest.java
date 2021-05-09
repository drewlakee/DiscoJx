package discojx.discogs.api.endpoints.database.requests.label;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface LabelRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
