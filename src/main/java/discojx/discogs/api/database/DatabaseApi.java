package discojx.discogs.api.database;

import discojx.discogs.api.database.requests.artist.ArtistRequestBuilder;
import discojx.discogs.api.database.requests.artist.releases.ArtistReleasesRequestBuilder;
import discojx.discogs.api.database.requests.label.LabelRequestBuilder;
import discojx.discogs.api.database.requests.label.releases.LabelReleasesRequestBuilder;
import discojx.discogs.api.database.requests.release.ReleaseRequestBuilder;
import discojx.discogs.api.database.requests.release.master.MasterReleaseRequestBuilder;
import discojx.discogs.api.database.requests.release.master.versions.MasterReleaseVersionsRequestBuilder;
import discojx.discogs.api.database.requests.release.rating.community.CommunityReleaseRatingRequestBuilder;
import discojx.discogs.api.database.requests.release.rating.user.ReleaseRatingByUserRequestBuilder;
import discojx.discogs.api.database.requests.release.rating.user.delete.ReleaseRatingDeleteByUserRequestBuilder;
import discojx.discogs.api.database.requests.release.rating.user.edit.ReleaseRatingUpdateByUserRequestBuilder;
import discojx.discogs.api.database.requests.release.stats.ReleaseStatsRequestBuilder;
import discojx.discogs.api.database.requests.search.SearchRequestBuilder;

public interface DatabaseApi {

    ReleaseRequestBuilder release();
    ReleaseStatsRequestBuilder releaseStats();
    ReleaseRatingByUserRequestBuilder releaseRatingByUser();
    ReleaseRatingUpdateByUserRequestBuilder releaseRatingUpdateByUser();
    ReleaseRatingDeleteByUserRequestBuilder releaseRatingDeleteByUser();
    CommunityReleaseRatingRequestBuilder communityReleaseRating();
    MasterReleaseRequestBuilder masterRelease();
    MasterReleaseVersionsRequestBuilder masterReleaseVersions();
    ArtistRequestBuilder artist();
    ArtistReleasesRequestBuilder artistReleases();
    LabelRequestBuilder label();
    LabelReleasesRequestBuilder labelReleases();
    SearchRequestBuilder search();
}