package discojx.discogs.api.user.collection.requests.collection.folder.release.add;

import discojx.requests.RequestBuilder;

public interface AddUserReleaseFolderCollectionItemRequestBuilder extends RequestBuilder<AddUserReleaseFolderCollectionItemRequest> {

    AddUserReleaseFolderCollectionItemRequestBuilder username(String username);
    AddUserReleaseFolderCollectionItemRequestBuilder folderId(long folderId);
    AddUserReleaseFolderCollectionItemRequestBuilder releaseId(long releaseId);
}
