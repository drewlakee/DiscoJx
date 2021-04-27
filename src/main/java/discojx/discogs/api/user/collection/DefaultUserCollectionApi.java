package discojx.discogs.api.user.collection;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.user.collection.requests.collection.DefaultUserFoldersRequest;
import discojx.discogs.api.user.collection.requests.collection.UserFoldersRequestBuilder;
import discojx.discogs.api.user.collection.requests.collection.create.CreateUserFolderRequestBuilder;
import discojx.discogs.api.user.collection.requests.collection.create.DefaultCreateUserFolderRequest;
import discojx.discogs.api.user.collection.requests.collection.folder.DefaultUserFolderRequest;
import discojx.discogs.api.user.collection.requests.collection.folder.UserFolderRequestBuilder;
import discojx.discogs.api.user.collection.requests.collection.folder.edit.DefaultEditUserFolderRequest;
import discojx.discogs.api.user.collection.requests.collection.folder.edit.EditUserFolderRequestBuilder;
import org.apache.http.HttpEntity;

import java.util.Objects;

public class DefaultUserCollectionApi implements UserCollectionApi {

    protected final AbstractHttpClient<HttpEntity> client;

    public DefaultUserCollectionApi(AbstractHttpClient<HttpEntity> client) {
        this.client = client;
    }

    @Override
    public UserFolderRequestBuilder folder() {
        return new DefaultUserFolderRequest.Builder(client);
    }

    @Override
    public UserFoldersRequestBuilder folders() {
        return new DefaultUserFoldersRequest.Builder(client);
    }

    @Override
    public EditUserFolderRequestBuilder editFolder() {
        return new DefaultEditUserFolderRequest.Builder(client);
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
