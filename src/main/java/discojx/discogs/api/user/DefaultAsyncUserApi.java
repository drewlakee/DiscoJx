package discojx.discogs.api.user;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.user.identity.AsyncIdentityApi;
import discojx.discogs.api.user.identity.DefaultAsyncIdentityApi;
import org.apache.http.HttpEntity;

import java.util.Objects;

public class DefaultAsyncUserApi implements AsyncUserApi {

    private final DefaultAsyncIdentityApi asyncIdentityApi;

    public DefaultAsyncUserApi(AbstractHttpClient<HttpEntity> client) {
        this.asyncIdentityApi = new DefaultAsyncIdentityApi(client);
    }

    @Override
    public AsyncIdentityApi identity() {
        return asyncIdentityApi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultAsyncUserApi that = (DefaultAsyncUserApi) o;
        return Objects.equals(asyncIdentityApi, that.asyncIdentityApi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(asyncIdentityApi);
    }
}
