package discojx.discogs.api.endpoints.user.collection.requests.folder.release.add;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface AddUserReleaseFolderCollectionItemRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
