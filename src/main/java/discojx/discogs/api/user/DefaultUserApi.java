package discojx.discogs.api.user;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.user.collection.DefaultUserCollectionApi;
import discojx.discogs.api.user.collection.UserCollectionApi;
import discojx.discogs.api.user.identity.DefaultIdentityApi;
import discojx.discogs.api.user.identity.IdentityApi;
import discojx.discogs.api.user.lists.DefaultUserListsApi;
import discojx.discogs.api.user.lists.UserListsApi;
import discojx.discogs.api.user.wantlist.DefaultUserWantListApi;
import discojx.discogs.api.user.wantlist.UserWantListApi;
import org.apache.http.HttpEntity;

import java.util.Objects;

public class DefaultUserApi implements UserApi {

    private final IdentityApi identityApi;
    private final UserListsApi userListsApi;
    private final UserWantListApi userWantListApi;
    private final UserCollectionApi userCollectionApi;

    public DefaultUserApi(AbstractHttpClient<HttpEntity> client) {
        this.identityApi = new DefaultIdentityApi(client);
        this.userListsApi = new DefaultUserListsApi(client);
        this.userWantListApi = new DefaultUserWantListApi(client);
        this.userCollectionApi = new DefaultUserCollectionApi(client);
    }

    @Override
    public IdentityApi identity() {
        return identityApi;
    }

    @Override
    public UserListsApi lists() {
        return userListsApi;
    }

    @Override
    public UserWantListApi wantList() {
        return userWantListApi;
    }

    @Override
    public UserCollectionApi collection() {
        return userCollectionApi;
    }

    @Override
    public String toString() {
        return "DefaultUserApi{" +
                "identityApi=" + identityApi +
                ", userListsApi=" + userListsApi +
                ", userWantListApi=" + userWantListApi +
                ", userCollectionApi=" + userCollectionApi +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultUserApi that = (DefaultUserApi) o;
        return Objects.equals(identityApi, that.identityApi) && Objects.equals(userListsApi, that.userListsApi) && Objects.equals(userWantListApi, that.userWantListApi) && Objects.equals(userCollectionApi, that.userCollectionApi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identityApi, userListsApi, userWantListApi, userCollectionApi);
    }
}
