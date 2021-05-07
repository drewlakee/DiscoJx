package discojx.discogs.api.endpoints.database.requests.release.rating.user.delete;

import discojx.discogs.api.requests.RequestBuilder;

public interface ReleaseRatingDeleteByUserRequestBuilder extends RequestBuilder<ReleaseRatingDeleteByUserRequest> {

    ReleaseRatingDeleteByUserRequestBuilder releaseId(long releaseId);
    ReleaseRatingDeleteByUserRequestBuilder username(String username);
}
