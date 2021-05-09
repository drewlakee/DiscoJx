package discojx.discogs.api.endpoints.user.collection;

import discojx.http.AbstractHttpClient;
import discojx.discogs.api.endpoints.user.collection.requests.UserFoldersRequestBuilder;
import discojx.discogs.api.endpoints.user.collection.requests.create.CreateUserFolderRequestBuilder;
import discojx.discogs.api.endpoints.user.collection.requests.fields.ListCustomFieldsRequestBuilder;
import discojx.discogs.api.endpoints.user.collection.requests.fields.edit.EditFieldsInstanceRequestBuilder;
import discojx.discogs.api.endpoints.user.collection.requests.folder.UserFolderRequestBuilder;
import discojx.discogs.api.endpoints.user.collection.requests.folder.delete.DeleteUserFolderRequestBuilder;
import discojx.discogs.api.endpoints.user.collection.requests.folder.edit.EditUserFolderRequestBuilder;
import discojx.discogs.api.endpoints.user.collection.requests.folder.release.UserReleaseFolderCollectionItemsRequestBuilder;
import discojx.discogs.api.endpoints.user.collection.requests.folder.release.add.AddUserReleaseFolderCollectionItemRequestBuilder;
import discojx.discogs.api.endpoints.user.collection.requests.release.UserReleaseCollectionItemsRequestBuilder;
import discojx.discogs.api.endpoints.user.collection.requests.release.delete.DeleteInstanceFromFolderRequestBuilder;
import discojx.discogs.api.endpoints.user.collection.requests.release.rating.ChangeReleaseRatingRequestBuilder;
import discojx.discogs.api.endpoints.user.collection.requests.value.UserCollectionValueRequestBuilder;
import discojx.discogs.api.requests.impl.*;

import java.util.Objects;

public class DefaultUserCollectionApi implements UserCollectionApi {

    protected final AbstractHttpClient client;

    public DefaultUserCollectionApi(AbstractHttpClient client) {
        this.client = client;
    }

    @Override
    public UserFolderRequestBuilder getFolder() {
        return new DefaultUserFolderRequest.Builder(client);
    }

    @Override
    public UserFoldersRequestBuilder getFolders() {
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
    public UserReleaseCollectionItemsRequestBuilder getCollectionItemsByRelease() {
        return new DefaultUserReleaseCollectionItemsRequest.Builder(client);
    }

    @Override
    public UserReleaseFolderCollectionItemsRequestBuilder getCollectionItemsByFolder() {
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
    public ListCustomFieldsRequestBuilder getListCustomFields() {
        return new DefaultListCustomFieldsRequest.Builder(client);
    }

    @Override
    public EditFieldsInstanceRequestBuilder editFieldsInstance() {
        return new DefaultEditFieldsInstanceRequest.Builder(client);
    }

    @Override
    public UserCollectionValueRequestBuilder getCollectionValue() {
        return new DefaultUserCollectionValueRequest.Builder(client);
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
