package discojx.discogs.api.endpoints.user.collection.requests.folder;

import discojx.discogs.api.requests.RequestBuilder;

public interface UserFolderRequestBuilder extends RequestBuilder<UserFolderRequest> {

    UserFolderRequestBuilder username(String username);
    UserFolderRequestBuilder folderId(long folderId);
}
