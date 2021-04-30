package discojx.discogs.api.database;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.database.requests.artist.ArtistRequestBuilder;
import discojx.discogs.api.database.requests.artist.DefaultArtistRequest;
import discojx.discogs.api.database.requests.artist.releases.ArtistReleasesRequestBuilder;
import discojx.discogs.api.database.requests.artist.releases.DefaultArtistReleasesRequest;
import discojx.discogs.api.database.requests.label.DefaultLabelRequest;
import discojx.discogs.api.database.requests.label.LabelRequestBuilder;
import discojx.discogs.api.database.requests.label.releases.DefaultLabelReleasesRequest;
import discojx.discogs.api.database.requests.label.releases.LabelReleasesRequestBuilder;
import discojx.discogs.api.database.requests.release.DefaultReleaseRequest;
import discojx.discogs.api.database.requests.release.ReleaseRequestBuilder;
import discojx.discogs.api.database.requests.release.master.DefaultMasterReleaseRequest;
import discojx.discogs.api.database.requests.release.master.MasterReleaseRequestBuilder;
import discojx.discogs.api.database.requests.release.master.versions.DefaultMasterReleaseVersionsRequest;
import discojx.discogs.api.database.requests.release.master.versions.MasterReleaseVersionsRequestBuilder;
import discojx.discogs.api.database.requests.release.rating.community.CommunityReleaseRatingRequestBuilder;
import discojx.discogs.api.database.requests.release.rating.community.DefaultCommunityReleaseRatingRequest;
import discojx.discogs.api.database.requests.release.rating.user.DefaultReleaseRatingByUserRequest;
import discojx.discogs.api.database.requests.release.rating.user.ReleaseRatingByUserRequestBuilder;
import discojx.discogs.api.database.requests.release.rating.user.delete.DefaultReleaseRatingDeleteByUserRequest;
import discojx.discogs.api.database.requests.release.rating.user.delete.ReleaseRatingDeleteByUserRequestBuilder;
import discojx.discogs.api.database.requests.release.rating.user.edit.DefaultReleaseRatingUpdateByUserRequest;
import discojx.discogs.api.database.requests.release.rating.user.edit.ReleaseRatingUpdateByUserRequestBuilder;
import discojx.discogs.api.database.requests.release.stats.DefaultReleaseStatsRequest;
import discojx.discogs.api.database.requests.release.stats.ReleaseStatsRequestBuilder;
import discojx.discogs.api.database.requests.search.DefaultSearchRequest;
import discojx.discogs.api.database.requests.search.SearchRequestBuilder;
import org.apache.http.HttpEntity;

import java.util.Objects;

public class DefaultDatabaseApi implements DatabaseApi {

    private final AbstractHttpClient client;

    public DefaultDatabaseApi(AbstractHttpClient client) {
        this.client = client;
    }

    @Override
    public ReleaseRequestBuilder release() {
        return new DefaultReleaseRequest.Builder(client);
    }

    @Override
    public ReleaseStatsRequestBuilder releaseStats() {
        return new DefaultReleaseStatsRequest.Builder(client);
    }

    @Override
    public ReleaseRatingByUserRequestBuilder releaseRatingByUser() {
        return new DefaultReleaseRatingByUserRequest.Builder(client);
    }

    @Override
    public ReleaseRatingUpdateByUserRequestBuilder releaseRatingUpdateByUser() {
        return new DefaultReleaseRatingUpdateByUserRequest.Builder(client);
    }

    @Override
    public ReleaseRatingDeleteByUserRequestBuilder releaseRatingDeleteByUser() {
        return new DefaultReleaseRatingDeleteByUserRequest.Builder(client);
    }

    @Override
    public CommunityReleaseRatingRequestBuilder communityReleaseRating() {
        return new DefaultCommunityReleaseRatingRequest.Builder(client);
    }

    @Override
    public MasterReleaseRequestBuilder masterRelease() {
        return new DefaultMasterReleaseRequest.Builder(client);
    }

    @Override
    public MasterReleaseVersionsRequestBuilder masterReleaseVersions() {
        return new DefaultMasterReleaseVersionsRequest.Builder(client);
    }

    @Override
    public ArtistRequestBuilder artist() {
        return new DefaultArtistRequest.Builder(client);
    }

    @Override
    public ArtistReleasesRequestBuilder artistReleases() {
        return new DefaultArtistReleasesRequest.Builder(client);
    }

    @Override
    public LabelRequestBuilder label() {
        return new DefaultLabelRequest.Builder(client);
    }

    @Override
    public LabelReleasesRequestBuilder labelReleases() {
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
