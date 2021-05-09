package discojx.discogs.api.endpoints.user.lists.requests;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface UserListsRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
