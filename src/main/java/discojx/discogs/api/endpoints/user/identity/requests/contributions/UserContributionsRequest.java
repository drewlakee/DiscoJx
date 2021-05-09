package discojx.discogs.api.endpoints.user.identity.requests.contributions;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface UserContributionsRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
