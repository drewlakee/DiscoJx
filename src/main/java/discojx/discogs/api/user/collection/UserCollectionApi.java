package discojx.discogs.api.user.collection;

import discojx.discogs.api.user.collection.requests.collection.UserFoldersRequestBuilder;
import discojx.discogs.api.user.collection.requests.collection.create.CreateUserFolderRequestBuilder;
import discojx.discogs.api.user.collection.requests.collection.folder.UserFolderRequestBuilder;

public interface UserCollectionApi {

    UserFolderRequestBuilder folder();
    UserFoldersRequestBuilder folders();
    CreateUserFolderRequestBuilder createFolder();
}
