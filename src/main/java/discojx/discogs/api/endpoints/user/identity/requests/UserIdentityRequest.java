package discojx.discogs.api.endpoints.user.identity.requests;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface UserIdentityRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
