package discojx.discogs.api.user;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.user.identity.IdentityApi;
import discojx.discogs.api.user.identity.DefaultIdentityApi;
import org.apache.http.HttpEntity;

import java.util.Objects;

public class DefaultUserApi implements UserApi {

    private final DefaultIdentityApi identityApi;

    public DefaultUserApi(AbstractHttpClient<HttpEntity> client) {
        this.identityApi = new DefaultIdentityApi(client);
    }

    @Override
    public IdentityApi identity() {
        return identityApi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultUserApi that = (DefaultUserApi) o;
        return Objects.equals(identityApi, that.identityApi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identityApi);
    }
}
