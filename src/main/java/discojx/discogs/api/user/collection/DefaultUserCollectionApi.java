package discojx.discogs.api.user.collection;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.user.collection.requests.folders.DefaultUserFoldersRequest;
import discojx.discogs.api.user.collection.requests.folders.UserFoldersRequestBuilder;
import discojx.discogs.api.user.collection.requests.folders.create.CreateUserFolderRequestBuilder;
import discojx.discogs.api.user.collection.requests.folders.create.DefaultCreateUserFolderRequest;
import org.apache.http.HttpEntity;

import java.util.Objects;

public class DefaultUserCollectionApi implements UserCollectionApi {

    protected final AbstractHttpClient<HttpEntity> client;

    public DefaultUserCollectionApi(AbstractHttpClient<HttpEntity> client) {
        this.client = client;
    }

    @Override
    public UserFoldersRequestBuilder folders() {
        return new DefaultUserFoldersRequest.Builder(client);
    }

    @Override
    public CreateUserFolderRequestBuilder createFolder() {
        return new DefaultCreateUserFolderRequest.Builder(client);
    }

    @Override
    public String toString() {
        return "DefaultUserCollectionApi{" +
                "client=" + client +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultUserCollectionApi that = (DefaultUserCollectionApi) o;
        return Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client);
    }
}
