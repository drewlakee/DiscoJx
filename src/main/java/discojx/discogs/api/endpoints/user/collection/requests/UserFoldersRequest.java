package discojx.discogs.api.endpoints.user.collection.requests;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface UserFoldersRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
