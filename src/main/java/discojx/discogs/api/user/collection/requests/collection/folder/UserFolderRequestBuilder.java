package discojx.discogs.api.user.collection.requests.collection.folder;

import discojx.requests.RequestBuilder;

public interface UserFolderRequestBuilder extends RequestBuilder<UserFolderRequest> {

    UserFolderRequestBuilder username(String username);
    UserFolderRequestBuilder folderId(long folderId);
}
