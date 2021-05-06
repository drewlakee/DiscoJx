package discojx.discogs.api.endpoints.database.requests.release.rating.user;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.ReleaseRating;

public interface ReleaseRatingByUserRequest extends AsyncExecutableRequest<EntityResponseWrapper<ReleaseRating>> {
}
