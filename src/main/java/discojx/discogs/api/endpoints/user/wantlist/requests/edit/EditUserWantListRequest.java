package discojx.discogs.api.endpoints.user.wantlist.requests.edit;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface EditUserWantListRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
