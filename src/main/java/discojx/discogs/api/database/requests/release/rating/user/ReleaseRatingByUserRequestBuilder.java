package discojx.discogs.api.database.requests.release.rating.user;

import discojx.requests.RequestBuilder;

public interface ReleaseRatingByUserRequestBuilder extends RequestBuilder<ReleaseRatingByUserRequest> {

    ReleaseRatingByUserRequestBuilder releaseId(long releaseId);
    ReleaseRatingByUserRequestBuilder username(String username);
}
