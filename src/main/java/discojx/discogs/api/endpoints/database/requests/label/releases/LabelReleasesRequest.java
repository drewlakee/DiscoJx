package discojx.discogs.api.endpoints.database.requests.label.releases;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface LabelReleasesRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
