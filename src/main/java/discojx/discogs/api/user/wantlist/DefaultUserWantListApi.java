package discojx.discogs.api.user.wantlist;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.user.wantlist.requests.DefaultUserWantListRequest;
import discojx.discogs.api.user.wantlist.requests.UserWantListRequestBuilder;
import org.apache.http.HttpEntity;

import java.util.Objects;

public class DefaultUserWantListApi implements UserWantListApi {

    protected final AbstractHttpClient<HttpEntity> client;

    public DefaultUserWantListApi(AbstractHttpClient<HttpEntity> client) {
        this.client = client;
    }

    @Override
    public UserWantListRequestBuilder wantList() {
        return new DefaultUserWantListRequest.Builder(client);
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
