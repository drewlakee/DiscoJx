package discojx.discogs.api.database;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.database.requests.release.AsyncReleaseRequestBuilder;
import discojx.discogs.api.database.requests.release.DefaultAsyncReleaseRequest;
import discojx.discogs.api.database.requests.release.master.AsyncMasterReleaseRequestBuilder;
import discojx.discogs.api.database.requests.release.master.DefaultAsyncMasterReleaseRequest;
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
import org.apache.http.HttpEntity;

import java.util.Objects;

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
    public String toString() {
        return "DefaultAsyncDatabaseApi{" +
                "client=" + client +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultAsyncDatabaseApi that = (DefaultAsyncDatabaseApi) o;
        return Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client);
    }
}
