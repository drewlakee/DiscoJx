package discojx.discogs.api.endpoints.user.collection.requests.release;

import discojx.discogs.api.requests.PaginationableRequest;
import discojx.discogs.api.requests.RequestBuilder;

public interface UserReleaseCollectionItemsRequestBuilder extends
        RequestBuilder<UserReleaseCollectionItemsRequest>,
        PaginationableRequest<UserReleaseCollectionItemsRequestBuilder> {

    UserReleaseCollectionItemsRequestBuilder username(String username);
    UserReleaseCollectionItemsRequestBuilder releaseId(long releaseId);
}
