package discojx.discogs.api.endpoints.user.lists.requests.list;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface UserListRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
