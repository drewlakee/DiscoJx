package discojx.discogs.api.endpoints.user.collection.requests.folder.delete;

import discojx.discogs.api.requests.RequestBuilder;

public interface DeleteUserFolderRequestBuilder extends RequestBuilder<DeleteUserFolderRequest> {

    DeleteUserFolderRequestBuilder username(String username);
    DeleteUserFolderRequestBuilder folderId(long folderId);
}
