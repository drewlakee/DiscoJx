package discojx.discogs.api.endpoints.database;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.endpoints.database.requests.artist.ArtistRequestBuilder;
import discojx.discogs.api.requests.impl.DefaultArtistRequest;
import discojx.discogs.api.endpoints.database.requests.artist.releases.ArtistReleasesRequestBuilder;
import discojx.discogs.api.requests.impl.DefaultArtistReleasesRequest;
import discojx.discogs.api.requests.impl.DefaultLabelRequest;
import discojx.discogs.api.endpoints.database.requests.label.LabelRequestBuilder;
import discojx.discogs.api.requests.impl.DefaultLabelReleasesRequest;
import discojx.discogs.api.endpoints.database.requests.label.releases.LabelReleasesRequestBuilder;
import discojx.discogs.api.requests.impl.DefaultReleaseRequest;
import discojx.discogs.api.endpoints.database.requests.release.ReleaseRequestBuilder;
import discojx.discogs.api.requests.impl.DefaultMasterReleaseRequest;
import discojx.discogs.api.endpoints.database.requests.release.master.MasterReleaseRequestBuilder;
import discojx.discogs.api.requests.impl.DefaultMasterReleaseVersionsRequest;
import discojx.discogs.api.endpoints.database.requests.release.master.versions.MasterReleaseVersionsRequestBuilder;
import discojx.discogs.api.endpoints.database.requests.release.rating.community.CommunityReleaseRatingRequestBuilder;
import discojx.discogs.api.requests.impl.DefaultCommunityReleaseRatingRequest;
import discojx.discogs.api.requests.impl.DefaultReleaseRatingByUserRequest;
import discojx.discogs.api.endpoints.database.requests.release.rating.user.ReleaseRatingByUserRequestBuilder;
import discojx.discogs.api.requests.impl.DefaultReleaseRatingDeleteByUserRequest;
import discojx.discogs.api.endpoints.database.requests.release.rating.user.delete.ReleaseRatingDeleteByUserRequestBuilder;
import discojx.discogs.api.requests.impl.DefaultReleaseRatingUpdateByUserRequest;
import discojx.discogs.api.endpoints.database.requests.release.rating.user.edit.ReleaseRatingUpdateByUserRequestBuilder;
import discojx.discogs.api.requests.impl.DefaultReleaseStatsRequest;
import discojx.discogs.api.endpoints.database.requests.release.stats.ReleaseStatsRequestBuilder;
import discojx.discogs.api.requests.impl.DefaultSearchRequest;
import discojx.discogs.api.endpoints.database.requests.search.SearchRequestBuilder;

import java.util.Objects;

public class DefaultDatabaseApi implements DatabaseApi {

    protected final AbstractHttpClient client;

    public DefaultDatabaseApi(AbstractHttpClient client) {
        this.client = client;
    }

    @Override
    public ReleaseRequestBuilder getRelease() {
        return new DefaultReleaseRequest.Builder(client);
    }

    @Override
    public ReleaseStatsRequestBuilder getReleaseStats() {
        return new DefaultReleaseStatsRequest.Builder(client);
    }

    @Override
    public ReleaseRatingByUserRequestBuilder getReleaseRatingByUser() {
        return new DefaultReleaseRatingByUserRequest.Builder(client);
    }

    @Override
    public ReleaseRatingUpdateByUserRequestBuilder updateReleaseRatingByUser() {
        return new DefaultReleaseRatingUpdateByUserRequest.Builder(client);
    }

    @Override
    public ReleaseRatingDeleteByUserRequestBuilder deleteReleaseRatingByUser() {
        return new DefaultReleaseRatingDeleteByUserRequest.Builder(client);
    }

    @Override
    public CommunityReleaseRatingRequestBuilder getCommunityReleaseRating() {
        return new DefaultCommunityReleaseRatingRequest.Builder(client);
    }

    @Override
    public MasterReleaseRequestBuilder getMasterRelease() {
        return new DefaultMasterReleaseRequest.Builder(client);
    }

    @Override
    public MasterReleaseVersionsRequestBuilder getMasterReleaseVersions() {
        return new DefaultMasterReleaseVersionsRequest.Builder(client);
    }

    @Override
    public ArtistRequestBuilder getArtist() {
        return new DefaultArtistRequest.Builder(client);
    }

    @Override
    public ArtistReleasesRequestBuilder getArtistReleases() {
        return new DefaultArtistReleasesRequest.Builder(client);
    }

    @Override
    public LabelRequestBuilder getLabel() {
        return new DefaultLabelRequest.Builder(client);
    }

    @Override
    public LabelReleasesRequestBuilder getLabelReleases() {
        return new DefaultLabelReleasesRequest.Builder(client);
    }

    @Override
    public SearchRequestBuilder search() {
        return new DefaultSearchRequest.Builder(client);
    }

    @Override
    public String toString() {
        return "DefaultDatabaseApi{" +
                "client=" + client +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultDatabaseApi that = (DefaultDatabaseApi) o;
        return Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client);
    }
}
