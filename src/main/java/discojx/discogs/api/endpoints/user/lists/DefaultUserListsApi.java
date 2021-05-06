package discojx.discogs.api.endpoints.user.lists;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.endpoints.user.lists.requests.UserListsRequestBuilder;
import discojx.discogs.api.endpoints.user.lists.requests.list.UserListRequestBuilder;
import discojx.discogs.api.requests.impl.DefaultUserListRequest;
import discojx.discogs.api.requests.impl.DefaultUserListsRequest;

import java.util.Objects;

public class DefaultUserListsApi implements UserListsApi {

    protected final AbstractHttpClient client;

    public DefaultUserListsApi(AbstractHttpClient client) {
        this.client = client;
    }

    @Override
    public UserListsRequestBuilder getLists() {
        return new DefaultUserListsRequest.Builder(client);
    }

    @Override
    public UserListRequestBuilder getList() {
        return new DefaultUserListRequest.Builder(client);
    }

    @Override
    public String toString() {
        return "DefaultUserListsApi{" +
                "client=" + client +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultUserListsApi that = (DefaultUserListsApi) o;
        return Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client);
    }
}
