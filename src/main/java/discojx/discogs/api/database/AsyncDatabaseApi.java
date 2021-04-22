package discojx.discogs.api.database;

import discojx.discogs.api.database.requests.artist.AsyncArtistRequestBuilder;
import discojx.discogs.api.database.requests.release.AsyncReleaseRequestBuilder;
import discojx.discogs.api.database.requests.release.master.AsyncMasterReleaseRequestBuilder;
import discojx.discogs.api.database.requests.release.master.versions.AsyncMasterReleaseVersionsRequestBuilder;
import discojx.discogs.api.database.requests.release.rating.community.AsyncCommunityReleaseRatingRequestBuilder;
import discojx.discogs.api.database.requests.release.rating.user.AsyncReleaseRatingByUserRequestBuilder;
import discojx.discogs.api.database.requests.release.rating.user.delete.AsyncReleaseRatingDeleteByUserRequestBuilder;
import discojx.discogs.api.database.requests.release.rating.user.edit.AsyncReleaseRatingUpdateByUserRequestBuilder;
import discojx.discogs.api.database.requests.release.stats.AsyncReleaseStatsRequestBuilder;

public interface AsyncDatabaseApi {

    AsyncReleaseRequestBuilder release();
    AsyncReleaseStatsRequestBuilder releaseStats();
    AsyncReleaseRatingByUserRequestBuilder releaseRatingByUser();
    AsyncReleaseRatingUpdateByUserRequestBuilder releaseRatingUpdateByUser();
    AsyncReleaseRatingDeleteByUserRequestBuilder releaseRatingDeleteByUser();
    AsyncCommunityReleaseRatingRequestBuilder communityReleaseRating();
    AsyncMasterReleaseRequestBuilder masterRelease();
    AsyncMasterReleaseVersionsRequestBuilder masterReleaseVersions();
    AsyncArtistRequestBuilder artist();
}
