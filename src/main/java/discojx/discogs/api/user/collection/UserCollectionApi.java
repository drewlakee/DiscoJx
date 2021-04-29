package discojx.discogs.api.user.collection;

import discojx.discogs.api.user.collection.requests.collection.UserFoldersRequestBuilder;
import discojx.discogs.api.user.collection.requests.collection.create.CreateUserFolderRequestBuilder;
import discojx.discogs.api.user.collection.requests.collection.fields.ListCustomFieldsRequestBuilder;
import discojx.discogs.api.user.collection.requests.collection.folder.UserFolderRequestBuilder;
import discojx.discogs.api.user.collection.requests.collection.folder.delete.DeleteUserFolderRequestBuilder;
import discojx.discogs.api.user.collection.requests.collection.folder.edit.EditUserFolderRequestBuilder;
import discojx.discogs.api.user.collection.requests.collection.folder.release.UserReleaseFolderCollectionItemsRequest;
import discojx.discogs.api.user.collection.requests.collection.folder.release.UserReleaseFolderCollectionItemsRequestBuilder;
import discojx.discogs.api.user.collection.requests.collection.folder.release.add.AddUserReleaseFolderCollectionItemRequestBuilder;
import discojx.discogs.api.user.collection.requests.collection.release.UserReleaseCollectionItemsRequestBuilder;
import discojx.discogs.api.user.collection.requests.collection.release.delete.DeleteInstanceFromFolderRequest;
import discojx.discogs.api.user.collection.requests.collection.release.delete.DeleteInstanceFromFolderRequestBuilder;
import discojx.discogs.api.user.collection.requests.collection.release.rating.ChangeReleaseRatingRequestBuilder;

public interface UserCollectionApi {

    UserFolderRequestBuilder folder();
    UserFoldersRequestBuilder folders();
    EditUserFolderRequestBuilder editFolder();
    CreateUserFolderRequestBuilder createFolder();
    DeleteUserFolderRequestBuilder deleteFolder();
    UserReleaseCollectionItemsRequestBuilder collectionItemsByRelease();
    UserReleaseFolderCollectionItemsRequestBuilder collectionItemsByFolder();
    AddUserReleaseFolderCollectionItemRequestBuilder addReleaseItemToCollectionFolder();
    ChangeReleaseRatingRequestBuilder changeRatingOfRelease();
    DeleteInstanceFromFolderRequestBuilder deleteInstanceFromFolder();
    ListCustomFieldsRequestBuilder listCustomFields();
}
