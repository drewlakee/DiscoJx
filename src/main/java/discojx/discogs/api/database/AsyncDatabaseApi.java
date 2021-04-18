package discojx.discogs.api.database;

import discojx.discogs.api.database.requests.release.AsyncReleaseRequestBuilder;
import discojx.discogs.api.database.requests.release.rating.user.AsyncReleaseRatingByUserRequestBuilder;

public interface AsyncDatabaseApi {

    AsyncReleaseRequestBuilder release();
    AsyncReleaseRatingByUserRequestBuilder releaseRatingByUser();
}
