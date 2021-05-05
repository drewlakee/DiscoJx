package discojx.discogs.api.endpoints.user.collection;

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

public interface UserCollectionApi {

    UserFolderRequestBuilder getFolder();
    UserFoldersRequestBuilder getFolders();
    EditUserFolderRequestBuilder editFolder();
    CreateUserFolderRequestBuilder createFolder();
    DeleteUserFolderRequestBuilder deleteFolder();
    UserReleaseCollectionItemsRequestBuilder getCollectionItemsByRelease();
    UserReleaseFolderCollectionItemsRequestBuilder getCollectionItemsByFolder();
    AddUserReleaseFolderCollectionItemRequestBuilder addReleaseItemToCollectionFolder();
    ChangeReleaseRatingRequestBuilder changeRatingOfRelease();
    DeleteInstanceFromFolderRequestBuilder deleteInstanceFromFolder();
    ListCustomFieldsRequestBuilder getListCustomFields();
    EditFieldsInstanceRequestBuilder editFieldsInstance();
    UserCollectionValueRequestBuilder getCollectionValue();
}
