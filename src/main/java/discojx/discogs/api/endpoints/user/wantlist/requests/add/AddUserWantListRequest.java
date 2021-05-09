package discojx.discogs.api.endpoints.user.wantlist.requests.add;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface AddUserWantListRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
