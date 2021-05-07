package discojx.discogs.api.endpoints.database.requests.release.rating.community;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.CommunityReleaseRating;

public interface CommunityReleaseRatingRequest extends AsyncExecutableRequest<EntityResponseWrapper<CommunityReleaseRating>> {
}
