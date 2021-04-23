package discojx.discogs.api.database;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.database.requests.artist.AsyncArtistRequestBuilder;
import discojx.discogs.api.database.requests.artist.DefaultAsyncArtistRequest;
import discojx.discogs.api.database.requests.artist.releases.AsyncArtistReleasesRequestBuilder;
import discojx.discogs.api.database.requests.artist.releases.DefaultAsyncArtistReleasesRequest;
import discojx.discogs.api.database.requests.label.AsyncLabelRequestBuilder;
import discojx.discogs.api.database.requests.label.DefaultAsyncLabelRequest;
import discojx.discogs.api.database.requests.label.releases.AsyncLabelReleasesRequestBuilder;
import discojx.discogs.api.database.requests.label.releases.DefaultAsyncLabelReleasesRequest;
import discojx.discogs.api.database.requests.release.AsyncReleaseRequestBuilder;
import discojx.discogs.api.database.requests.release.DefaultAsyncReleaseRequest;
import discojx.discogs.api.database.requests.release.master.AsyncMasterReleaseRequestBuilder;
import discojx.discogs.api.database.requests.release.master.DefaultAsyncMasterReleaseRequest;
import discojx.discogs.api.database.requests.release.master.versions.AsyncMasterReleaseVersionsRequestBuilder;
import discojx.discogs.api.database.requests.release.master.versions.DefaultAsyncMasterReleaseVersionsRequest;
import discojx.discogs.api.database.requests.release.rating.community.AsyncCommunityReleaseRatingRequestBuilder;
import discojx.discogs.api.database.requests.release.rating.community.DefaultAsyncCommunityReleaseRatingRequest;
import discojx.discogs.api.database.requests.release.rating.user.AsyncReleaseRatingByUserRequestBuilder;
import discojx.discogs.api.database.requests.release.rating.user.DefaultAsyncReleaseRatingByUserRequest;
import discojx.discogs.api.database.requests.release.rating.user.delete.AsyncReleaseRatingDeleteByUserRequestBuilder;
import discojx.discogs.api.database.requests.release.rating.user.delete.DefaultAsyncReleaseRatingDeleteByUserRequest;
import discojx.discogs.api.database.requests.release.rating.user.edit.AsyncReleaseRatingUpdateByUserRequestBuilder;
import discojx.discogs.api.database.requests.release.rating.user.edit.DefaultAsyncReleaseRatingUpdateByUserRequest;
import discojx.discogs.api.database.requests.release.stats.AsyncReleaseStatsRequestBuilder;
import discojx.discogs.api.database.requests.release.stats.DefaultAsyncReleaseStatsRequest;
import discojx.discogs.api.database.requests.search.AsyncSearchRequestBuilder;
import discojx.discogs.api.database.requests.search.DefaultAsyncSearchRequest;
import org.apache.http.HttpEntity;

public class DefaultAsyncDatabaseApi implements AsyncDatabaseApi {

    private final AbstractHttpClient<HttpEntity> client;

    public DefaultAsyncDatabaseApi(AbstractHttpClient<HttpEntity> client) {
        this.client = client;
    }

    @Override
    public AsyncReleaseRequestBuilder release() {
        return new DefaultAsyncReleaseRequest.Builder(client);
    }

    @Override
    public AsyncReleaseStatsRequestBuilder releaseStats() {
        return new DefaultAsyncReleaseStatsRequest.Builder(client);
    }

    @Override
    public AsyncReleaseRatingByUserRequestBuilder releaseRatingByUser() {
        return new DefaultAsyncReleaseRatingByUserRequest.Builder(client);
    }

    @Override
    public AsyncReleaseRatingUpdateByUserRequestBuilder releaseRatingUpdateByUser() {
        return new DefaultAsyncReleaseRatingUpdateByUserRequest.Builder(client);
    }

    @Override
    public AsyncReleaseRatingDeleteByUserRequestBuilder releaseRatingDeleteByUser() {
        return new DefaultAsyncReleaseRatingDeleteByUserRequest.Builder(client);
    }

    @Override
    public AsyncCommunityReleaseRatingRequestBuilder communityReleaseRating() {
        return new DefaultAsyncCommunityReleaseRatingRequest.Builder(client);
    }

    @Override
    public AsyncMasterReleaseRequestBuilder masterRelease() {
        return new DefaultAsyncMasterReleaseRequest.Builder(client);
    }

    @Override
    public AsyncMasterReleaseVersionsRequestBuilder masterReleaseVersions() {
        return new DefaultAsyncMasterReleaseVersionsRequest.Builder(client);
    }

    @Override
    public AsyncArtistRequestBuilder artist() {
        return new DefaultAsyncArtistRequest.Builder(client);
    }

    @Override
    public AsyncArtistReleasesRequestBuilder artistReleases() {
        return new DefaultAsyncArtistReleasesRequest.Builder(client);
    }

    @Override
    public AsyncLabelRequestBuilder label() {
        return new DefaultAsyncLabelRequest.Builder(client);
    }

    @Override
    public AsyncLabelReleasesRequestBuilder labelReleases() {
        return new DefaultAsyncLabelReleasesRequest.Builder(client);
    }

    @Override
    public AsyncSearchRequestBuilder search() {
        return new DefaultAsyncSearchRequest.Builder(client);
    }

    @Override
    public String toString() {
        return "DefaultAsyncDatabaseApi{" +
                "client=" + client +
                '}';
    }
}
