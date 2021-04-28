package discojx.discogs.api.user.collection.requests.collection.folder.release;

import discojx.requests.PaginationableRequest;
import discojx.requests.RequestBuilder;
import discojx.requests.SortableRequest;

public interface UserReleaseFolderCollectionItemsRequestBuilder extends
        RequestBuilder<UserReleaseFolderCollectionItemsRequest>,
        PaginationableRequest<UserReleaseFolderCollectionItemsRequestBuilder>,
        SortableRequest<UserReleaseFolderCollectionItemsRequestBuilder> {

    UserReleaseFolderCollectionItemsRequestBuilder username(String username);
    UserReleaseFolderCollectionItemsRequestBuilder folderId(long folderId);
}
