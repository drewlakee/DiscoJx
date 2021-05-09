package discojx.discogs.api.endpoints.database.requests.release.rating.user.edit;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface ReleaseRatingUpdateByUserRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
