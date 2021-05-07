package discojx.discogs.api.endpoints.user.collection.requests.folder.release;

import discojx.discogs.api.requests.PaginationableRequest;
import discojx.discogs.api.requests.RequestBuilder;
import discojx.discogs.api.requests.SortableRequest;

public interface UserReleaseFolderCollectionItemsRequestBuilder extends
        RequestBuilder<UserReleaseFolderCollectionItemsRequest>,
        PaginationableRequest<UserReleaseFolderCollectionItemsRequestBuilder>,
        SortableRequest<UserReleaseFolderCollectionItemsRequestBuilder> {

    UserReleaseFolderCollectionItemsRequestBuilder username(String username);
    UserReleaseFolderCollectionItemsRequestBuilder folderId(long folderId);
}
