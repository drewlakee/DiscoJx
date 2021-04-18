package discojx.discogs.api;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.database.AsyncDatabaseApi;
import discojx.discogs.api.database.DefaultAsyncDatabaseApi;
import discojx.discogs.api.user.AsyncUserApi;
import discojx.discogs.api.user.DefaultAsyncUserApi;
import org.apache.http.HttpEntity;

import java.util.Objects;

public class DefaultAsyncDiscogsApi implements AsyncDiscogsApi {

    private final DefaultAsyncUserApi asyncUserApi;
    private final DefaultAsyncDatabaseApi asyncDatabaseApi;

    public DefaultAsyncDiscogsApi(AbstractHttpClient<HttpEntity> client) {
        this.asyncUserApi = new DefaultAsyncUserApi(client);
        this.asyncDatabaseApi = new DefaultAsyncDatabaseApi(client);
    }

    @Override
    public AsyncUserApi user() {
        return asyncUserApi;
    }

    @Override
    public AsyncDatabaseApi database() {
        return asyncDatabaseApi;
    }

    @Override
    public String toString() {
        return "DefaultAsyncDiscogsApi{" +
                "asyncUserApi=" + asyncUserApi +
                ", asyncDatabaseApi=" + asyncDatabaseApi +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultAsyncDiscogsApi api = (DefaultAsyncDiscogsApi) o;
        return Objects.equals(asyncUserApi, api.asyncUserApi) && Objects.equals(asyncDatabaseApi, api.asyncDatabaseApi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(asyncUserApi, asyncDatabaseApi);
    }
}
