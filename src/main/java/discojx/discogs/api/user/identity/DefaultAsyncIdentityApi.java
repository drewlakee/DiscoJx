package discojx.discogs.api.user.identity;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.user.identity.requests.AsyncUserIdentityRequest;
import discojx.discogs.api.user.identity.requests.DefaultCachedAsyncUserIdentityRequest;
import org.apache.http.HttpEntity;

import java.util.Objects;

public class DefaultAsyncIdentityApi implements AsyncIdentityApi {

    private final AbstractHttpClient<HttpEntity> client;

    public DefaultAsyncIdentityApi(AbstractHttpClient<HttpEntity> client) {
        this.client = client;
    }

    @Override
    public AsyncUserIdentityRequest self() {
        return new DefaultCachedAsyncUserIdentityRequest(client);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultAsyncIdentityApi that = (DefaultAsyncIdentityApi) o;
        return Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client);
    }
}
