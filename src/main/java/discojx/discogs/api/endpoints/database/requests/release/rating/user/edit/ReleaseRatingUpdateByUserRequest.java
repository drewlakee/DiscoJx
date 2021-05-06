package discojx.discogs.api.endpoints.database.requests.release.rating.user.edit;

import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.ReleaseRating;
import discojx.discogs.api.requests.AsyncExecutableRequest;

public interface ReleaseRatingUpdateByUserRequest extends AsyncExecutableRequest<EntityResponseWrapper<ReleaseRating>> {
}
