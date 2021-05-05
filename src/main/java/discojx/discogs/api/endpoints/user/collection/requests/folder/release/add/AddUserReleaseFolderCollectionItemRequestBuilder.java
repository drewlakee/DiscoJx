package discojx.discogs.api.endpoints.user.collection.requests.folder.release.add;

import discojx.discogs.api.requests.RequestBuilder;

public interface AddUserReleaseFolderCollectionItemRequestBuilder extends RequestBuilder<AddUserReleaseFolderCollectionItemRequest> {

    AddUserReleaseFolderCollectionItemRequestBuilder username(String username);
    AddUserReleaseFolderCollectionItemRequestBuilder folderId(long folderId);
    AddUserReleaseFolderCollectionItemRequestBuilder releaseId(long releaseId);
}
