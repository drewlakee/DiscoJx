package discojx.discogs.api.endpoints.database.requests.release.rating.user;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface ReleaseRatingByUserRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
