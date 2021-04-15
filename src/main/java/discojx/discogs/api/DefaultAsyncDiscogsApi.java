package discojx.discogs.api;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.user.AsyncUserApi;
import discojx.discogs.api.user.DefaultAsyncUserApi;
import org.apache.http.HttpEntity;

import java.util.Objects;

public class DefaultAsyncDiscogsApi implements AsyncDiscogsApi {

    private final DefaultAsyncUserApi asyncUserApi;

    public DefaultAsyncDiscogsApi(AbstractHttpClient<HttpEntity> client) {
        this.asyncUserApi = new DefaultAsyncUserApi(client);
    }

    @Override
    public AsyncUserApi user() {
        return asyncUserApi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultAsyncDiscogsApi that = (DefaultAsyncDiscogsApi) o;
        return Objects.equals(asyncUserApi, that.asyncUserApi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(asyncUserApi);
    }
}
