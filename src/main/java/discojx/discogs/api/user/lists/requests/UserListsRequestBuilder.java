package discojx.discogs.api.user.lists.requests;

import discojx.requests.PaginationableRequest;
import discojx.requests.RequestBuilder;

public interface UserListsRequestBuilder extends RequestBuilder<UserListsRequest>,
        PaginationableRequest<UserListsRequestBuilder> {

    UserListsRequestBuilder username(String username);
}
