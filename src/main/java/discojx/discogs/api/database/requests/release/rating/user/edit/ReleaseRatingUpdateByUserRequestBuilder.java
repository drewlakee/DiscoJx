package discojx.discogs.api.database.requests.release.rating.user.edit;

import discojx.requests.RequestBuilder;

public interface ReleaseRatingUpdateByUserRequestBuilder extends RequestBuilder<ReleaseRatingUpdateByUserRequest> {

    ReleaseRatingUpdateByUserRequestBuilder releaseId(long releaseId);
    ReleaseRatingUpdateByUserRequestBuilder username(String username);
    ReleaseRatingUpdateByUserRequestBuilder rating(int rating);
}
