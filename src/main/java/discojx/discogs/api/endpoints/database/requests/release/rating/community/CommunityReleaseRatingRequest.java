package discojx.discogs.api.endpoints.database.requests.release.rating.community;

import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.CommunityReleaseRating;
import discojx.discogs.api.requests.AsyncExecutableRequest;

public interface CommunityReleaseRatingRequest extends AsyncExecutableRequest<EntityResponseWrapper<CommunityReleaseRating>> {
}
