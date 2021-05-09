package discojx.discogs.api.endpoints.user.identity.requests.profile;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface ProfileRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
