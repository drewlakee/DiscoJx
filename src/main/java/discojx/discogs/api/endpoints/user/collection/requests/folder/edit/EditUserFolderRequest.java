package discojx.discogs.api.endpoints.user.collection.requests.folder.edit;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface EditUserFolderRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
