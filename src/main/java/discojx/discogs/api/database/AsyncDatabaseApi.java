package discojx.discogs.api.database;

import discojx.discogs.api.database.requests.release.AsyncReleaseRequestBuilder;
import discojx.discogs.api.database.requests.release.rating.community.AsyncCommunityReleaseRatingRequestBuilder;
import discojx.discogs.api.database.requests.release.rating.user.AsyncReleaseRatingByUserRequestBuilder;
import discojx.discogs.api.database.requests.release.rating.user.delete.AsyncReleaseRatingDeleteByUserRequestBuilder;
import discojx.discogs.api.database.requests.release.rating.user.edit.AsyncReleaseRatingUpdateByUserRequestBuilder;

public interface AsyncDatabaseApi {

    AsyncReleaseRequestBuilder release();
    AsyncReleaseRatingByUserRequestBuilder releaseRatingByUser();
    AsyncReleaseRatingUpdateByUserRequestBuilder releaseRatingUpdateByUser();
    AsyncReleaseRatingDeleteByUserRequestBuilder releaseRatingDeleteByUser();
    AsyncCommunityReleaseRatingRequestBuilder communityReleaseRating();
}
