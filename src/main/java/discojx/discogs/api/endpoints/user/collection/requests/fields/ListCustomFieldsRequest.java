package discojx.discogs.api.endpoints.user.collection.requests.fields;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface ListCustomFieldsRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
