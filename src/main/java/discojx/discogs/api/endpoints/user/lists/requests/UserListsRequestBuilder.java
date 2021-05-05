package discojx.discogs.api.endpoints.user.lists.requests;

import discojx.discogs.api.requests.PaginationableRequest;
import discojx.discogs.api.requests.RequestBuilder;

public interface UserListsRequestBuilder extends RequestBuilder<UserListsRequest>,
        PaginationableRequest<UserListsRequestBuilder> {

    UserListsRequestBuilder username(String username);
}
