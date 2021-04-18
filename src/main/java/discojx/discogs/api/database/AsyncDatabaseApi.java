package discojx.discogs.api.database;

import discojx.discogs.api.database.requests.release.AsyncReleaseRequestBuilder;

public interface AsyncDatabaseApi {

    AsyncReleaseRequestBuilder release();
}
