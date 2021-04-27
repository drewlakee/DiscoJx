package discojx.discogs.api.user.collection.requests.collection.folder.delete;

import discojx.requests.RequestBuilder;

public interface DeleteUserFolderRequestBuilder extends RequestBuilder<DeleteUserFolderRequest> {

    DeleteUserFolderRequestBuilder username(String username);
    DeleteUserFolderRequestBuilder folderId(long folderId);
}
