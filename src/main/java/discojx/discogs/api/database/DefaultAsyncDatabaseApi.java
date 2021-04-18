package discojx.discogs.api.database;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.database.requests.release.AsyncReleaseRequestBuilder;
import discojx.discogs.api.database.requests.release.DefaultAsyncReleaseRequest;
import discojx.discogs.api.database.requests.release.rating.user.AsyncReleaseRatingByUserRequestBuilder;
import discojx.discogs.api.database.requests.release.rating.user.DefaultAsyncReleaseRatingByUserRequest;
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
    public AsyncReleaseRatingByUserRequestBuilder releaseRatingByUser() {
        return new DefaultAsyncReleaseRatingByUserRequest.Builder(client);
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
