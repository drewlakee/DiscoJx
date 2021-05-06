package discojx.discogs.api.endpoints.user.wantlist;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.endpoints.user.wantlist.requests.UserWantListRequestBuilder;
import discojx.discogs.api.endpoints.user.wantlist.requests.add.AddUserWantListRequestBuilder;
import discojx.discogs.api.endpoints.user.wantlist.requests.delete.DeleteUserWantListRequestBuilder;
import discojx.discogs.api.endpoints.user.wantlist.requests.edit.EditUserWantListRequestBuilder;
import discojx.discogs.api.requests.impl.DefaultAddUserWantListRequest;
import discojx.discogs.api.requests.impl.DefaultDeleteUserWantListRequest;
import discojx.discogs.api.requests.impl.DefaultEditUserWantListRequest;
import discojx.discogs.api.requests.impl.DefaultUserWantListRequest;

import java.util.Objects;

public class DefaultUserWantListApi implements UserWantListApi {

    protected final AbstractHttpClient client;

    public DefaultUserWantListApi(AbstractHttpClient client) {
        this.client = client;
    }

    @Override
    public UserWantListRequestBuilder getWantList() {
        return new DefaultUserWantListRequest.Builder(client);
    }

    @Override
    public AddUserWantListRequestBuilder addWantList() {
        return new DefaultAddUserWantListRequest.Builder(client);
    }

    @Override
    public EditUserWantListRequestBuilder editWantList() {
        return new DefaultEditUserWantListRequest.Builder(client);
    }

    @Override
    public DeleteUserWantListRequestBuilder deleteWantList() {
        return new DefaultDeleteUserWantListRequest.Builder(client);
    }

    @Override
    public String toString() {
        return "DefaultUserWantListApi{" +
                "client=" + client +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultUserWantListApi that = (DefaultUserWantListApi) o;
        return Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client);
    }
}
