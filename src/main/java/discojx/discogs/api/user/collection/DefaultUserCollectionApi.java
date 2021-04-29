package discojx.discogs.api.user.collection;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.user.collection.requests.collection.DefaultUserFoldersRequest;
import discojx.discogs.api.user.collection.requests.collection.UserFoldersRequestBuilder;
import discojx.discogs.api.user.collection.requests.collection.create.CreateUserFolderRequestBuilder;
import discojx.discogs.api.user.collection.requests.collection.create.DefaultCreateUserFolderRequest;
import discojx.discogs.api.user.collection.requests.collection.fields.DefaultListCustomFieldsRequest;
import discojx.discogs.api.user.collection.requests.collection.fields.ListCustomFieldsRequestBuilder;
import discojx.discogs.api.user.collection.requests.collection.folder.DefaultUserFolderRequest;
import discojx.discogs.api.user.collection.requests.collection.folder.UserFolderRequestBuilder;
import discojx.discogs.api.user.collection.requests.collection.folder.delete.DefaultDeleteUserFolderRequest;
import discojx.discogs.api.user.collection.requests.collection.folder.delete.DeleteUserFolderRequestBuilder;
import discojx.discogs.api.user.collection.requests.collection.folder.edit.DefaultEditUserFolderRequest;
import discojx.discogs.api.user.collection.requests.collection.folder.edit.EditUserFolderRequestBuilder;
import discojx.discogs.api.user.collection.requests.collection.folder.release.DefaultUserReleaseFolderCollectionItemsRequest;
import discojx.discogs.api.user.collection.requests.collection.folder.release.UserReleaseFolderCollectionItemsRequestBuilder;
import discojx.discogs.api.user.collection.requests.collection.folder.release.add.AddUserReleaseFolderCollectionItemRequestBuilder;
import discojx.discogs.api.user.collection.requests.collection.folder.release.add.DefaultAddUserReleaseFolderCollectionItemRequest;
import discojx.discogs.api.user.collection.requests.collection.release.DefaultUserReleaseCollectionItemsRequest;
import discojx.discogs.api.user.collection.requests.collection.release.UserReleaseCollectionItemsRequestBuilder;
import discojx.discogs.api.user.collection.requests.collection.release.delete.DefaultDeleteInstanceFromFolderRequest;
import discojx.discogs.api.user.collection.requests.collection.release.delete.DeleteInstanceFromFolderRequestBuilder;
import discojx.discogs.api.user.collection.requests.collection.release.rating.ChangeReleaseRatingRequestBuilder;
import discojx.discogs.api.user.collection.requests.collection.release.rating.DefaultChangeReleaseRatingRequest;
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
    public DeleteUserFolderRequestBuilder deleteFolder() {
        return new DefaultDeleteUserFolderRequest.Builder(client);
    }

    @Override
    public UserReleaseCollectionItemsRequestBuilder collectionItemsByRelease() {
        return new DefaultUserReleaseCollectionItemsRequest.Builder(client);
    }

    @Override
    public UserReleaseFolderCollectionItemsRequestBuilder collectionItemsByFolder() {
        return new DefaultUserReleaseFolderCollectionItemsRequest.Builder(client);
    }

    @Override
    public AddUserReleaseFolderCollectionItemRequestBuilder addReleaseItemToCollectionFolder() {
        return new DefaultAddUserReleaseFolderCollectionItemRequest.Builder(client);
    }

    @Override
    public ChangeReleaseRatingRequestBuilder changeRatingOfRelease() {
        return new DefaultChangeReleaseRatingRequest.Builder(client);
    }

    @Override
    public DeleteInstanceFromFolderRequestBuilder deleteInstanceFromFolder() {
        return new DefaultDeleteInstanceFromFolderRequest.Builder(client);
    }

    @Override
    public ListCustomFieldsRequestBuilder listCustomFields() {
        return new DefaultListCustomFieldsRequest.Builder(client);
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
