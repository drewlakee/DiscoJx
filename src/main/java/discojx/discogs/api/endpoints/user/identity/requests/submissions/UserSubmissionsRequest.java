package discojx.discogs.api.endpoints.user.identity.requests.submissions;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface UserSubmissionsRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
