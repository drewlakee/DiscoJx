package discojx.discogs.api.user.lists;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.user.lists.requests.DefaultUserListsRequest;
import discojx.discogs.api.user.lists.requests.UserListsRequestBuilder;
import discojx.discogs.api.user.lists.requests.list.DefaultUserListRequest;
import discojx.discogs.api.user.lists.requests.list.UserListRequestBuilder;
import org.apache.http.HttpEntity;

import java.util.Objects;

public class DefaultUserListsApi implements UserListsApi {

    private final AbstractHttpClient<HttpEntity> client;

    public DefaultUserListsApi(AbstractHttpClient<HttpEntity> client) {
        this.client = client;
    }

    @Override
    public UserListsRequestBuilder lists() {
        return new DefaultUserListsRequest.Builder(client);
    }

    @Override
    public UserListRequestBuilder list() {
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
