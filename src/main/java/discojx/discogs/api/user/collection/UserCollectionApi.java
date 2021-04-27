package discojx.discogs.api.user.collection;

import discojx.discogs.api.user.collection.requests.folders.UserFoldersRequestBuilder;
import discojx.discogs.api.user.collection.requests.folders.create.CreateUserFolderRequestBuilder;

public interface UserCollectionApi {

    UserFoldersRequestBuilder folders();
    CreateUserFolderRequestBuilder createFolder();
}
