package discojx.discogs.api.user.collection;

import discojx.discogs.api.user.collection.requests.collection.UserFoldersRequestBuilder;
import discojx.discogs.api.user.collection.requests.collection.create.CreateUserFolderRequestBuilder;
import discojx.discogs.api.user.collection.requests.collection.folder.UserFolderRequestBuilder;
import discojx.discogs.api.user.collection.requests.collection.folder.delete.DeleteUserFolderRequestBuilder;
import discojx.discogs.api.user.collection.requests.collection.folder.edit.EditUserFolderRequestBuilder;
import discojx.discogs.api.user.collection.requests.collection.folder.release.UserReleaseFolderCollectionItemsRequest;
import discojx.discogs.api.user.collection.requests.collection.folder.release.UserReleaseFolderCollectionItemsRequestBuilder;
import discojx.discogs.api.user.collection.requests.collection.release.UserReleaseCollectionItemsRequestBuilder;

public interface UserCollectionApi {

    UserFolderRequestBuilder folder();
    UserFoldersRequestBuilder folders();
    EditUserFolderRequestBuilder editFolder();
    CreateUserFolderRequestBuilder createFolder();
    DeleteUserFolderRequestBuilder deleteFolder();
    UserReleaseCollectionItemsRequestBuilder collectionItemsByRelease();
    UserReleaseFolderCollectionItemsRequestBuilder collectionItemsByFolder();
}
