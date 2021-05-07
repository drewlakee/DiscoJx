package discojx.discogs.api.endpoints.database.requests.release.rating.user;

import discojx.discogs.api.requests.RequestBuilder;

public interface ReleaseRatingByUserRequestBuilder extends RequestBuilder<ReleaseRatingByUserRequest> {

    ReleaseRatingByUserRequestBuilder releaseId(long releaseId);
    ReleaseRatingByUserRequestBuilder username(String username);
}
