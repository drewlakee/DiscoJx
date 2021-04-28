package discojx.discogs.api.user.collection.requests.collection.release.delete;

import discojx.requests.RequestBuilder;

public interface DeleteInstanceFromFolderRequestBuilder extends RequestBuilder<DeleteInstanceFromFolderRequest> {

    DeleteInstanceFromFolderRequestBuilder username(String username);
    DeleteInstanceFromFolderRequestBuilder folderId(long folderId);
    DeleteInstanceFromFolderRequestBuilder releaseId(long releaseId);
    DeleteInstanceFromFolderRequestBuilder instanceId(long instanceId);
    DeleteInstanceFromFolderRequestBuilder makeUncategorized(boolean isUncategorized);
}
