package discojx.discogs.api.user;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.user.identity.IdentityApi;
import discojx.discogs.api.user.identity.DefaultIdentityApi;
import discojx.discogs.api.user.lists.DefaultUserListsApi;
import discojx.discogs.api.user.lists.UserListsApi;
import org.apache.http.HttpEntity;

import java.util.Objects;

public class DefaultUserApi implements UserApi {

    private final IdentityApi identityApi;
    private final UserListsApi userListsApi;

    public DefaultUserApi(AbstractHttpClient<HttpEntity> client) {
        this.identityApi = new DefaultIdentityApi(client);
        this.userListsApi = new DefaultUserListsApi(client);
    }

    @Override
    public IdentityApi identity() {
        return identityApi;
    }

    @Override
    public UserListsApi userLists() {
        return userListsApi;
    }

    @Override
    public String toString() {
        return "DefaultUserApi{" +
                "identityApi=" + identityApi +
                ", userListsApi=" + userListsApi +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultUserApi that = (DefaultUserApi) o;
        return Objects.equals(identityApi, that.identityApi) && Objects.equals(userListsApi, that.userListsApi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identityApi, userListsApi);
    }
}
