package discojx.discogs.api.endpoints.user.collection.requests.release.delete;

import discojx.discogs.api.requests.RequestBuilder;

public interface DeleteInstanceFromFolderRequestBuilder extends RequestBuilder<DeleteInstanceFromFolderRequest> {

    DeleteInstanceFromFolderRequestBuilder username(String username);
    DeleteInstanceFromFolderRequestBuilder folderId(long folderId);
    DeleteInstanceFromFolderRequestBuilder releaseId(long releaseId);
    DeleteInstanceFromFolderRequestBuilder instanceId(long instanceId);
    DeleteInstanceFromFolderRequestBuilder makeUncategorized(boolean isUncategorized);
}
