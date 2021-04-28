package discojx.discogs.api.user.collection.requests.collection.release;

import discojx.requests.PaginationableRequest;
import discojx.requests.RequestBuilder;

public interface UserReleaseCollectionItemsRequestBuilder extends
        RequestBuilder<UserReleaseCollectionItemsRequest>,
        PaginationableRequest<UserReleaseCollectionItemsRequestBuilder> {

    UserReleaseCollectionItemsRequestBuilder username(String username);
    UserReleaseCollectionItemsRequestBuilder releaseId(long releaseId);
}
