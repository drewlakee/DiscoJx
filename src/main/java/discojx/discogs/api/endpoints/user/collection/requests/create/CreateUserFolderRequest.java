package discojx.discogs.api.endpoints.user.collection.requests.create;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface CreateUserFolderRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
