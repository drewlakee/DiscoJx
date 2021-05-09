package discojx.discogs.api.endpoints.user.collection.requests.folder.release;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface UserReleaseFolderCollectionItemsRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
