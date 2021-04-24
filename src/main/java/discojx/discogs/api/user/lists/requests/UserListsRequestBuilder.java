package discojx.discogs.api.user.lists.requests;

import discojx.requests.PaginationableRequest;
import discojx.requests.PathParameterizedRequest;
import discojx.utils.requests.RequestParametersConstructor;

public interface UserListsRequestBuilder extends
        PaginationableRequest<UserListsRequestBuilder>,
        PathParameterizedRequest<RequestParametersConstructor> {

    UserListsRequestBuilder username(String username);

    UserListsRequest build();
}
