package discojx.discogs.api.endpoints.user.wantlist.requests;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface UserWantListRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
