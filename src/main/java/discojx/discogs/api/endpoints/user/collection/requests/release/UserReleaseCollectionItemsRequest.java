package discojx.discogs.api.endpoints.user.collection.requests.release;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface UserReleaseCollectionItemsRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
