package discojx.discogs.api.database.requests.release.rating.user.delete;

import discojx.requests.RequestBuilder;

public interface ReleaseRatingDeleteByUserRequestBuilder extends RequestBuilder<ReleaseRatingDeleteByUserRequest> {

    ReleaseRatingDeleteByUserRequestBuilder releaseId(long releaseId);
    ReleaseRatingDeleteByUserRequestBuilder username(String username);
}
