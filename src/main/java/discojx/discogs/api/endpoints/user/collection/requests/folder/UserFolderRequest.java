package discojx.discogs.api.endpoints.user.collection.requests.folder;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface UserFolderRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
