package discojx.discogs.api.user.collection;

import discojx.discogs.api.user.collection.requests.collection.UserFoldersRequestBuilder;
import discojx.discogs.api.user.collection.requests.collection.create.CreateUserFolderRequestBuilder;

public interface UserCollectionApi {

    UserFoldersRequestBuilder folders();
    CreateUserFolderRequestBuilder createFolder();
}
