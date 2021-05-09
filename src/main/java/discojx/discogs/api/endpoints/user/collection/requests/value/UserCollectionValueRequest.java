package discojx.discogs.api.endpoints.user.collection.requests.value;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface UserCollectionValueRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
