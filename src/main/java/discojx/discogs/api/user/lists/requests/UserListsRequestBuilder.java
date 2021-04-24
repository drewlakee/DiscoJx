package discojx.discogs.api.user.lists.requests;

import discojx.requests.PaginationableRequest;
import discojx.requests.ParameterizedRequest;
import discojx.utils.requests.RequestParametersConstructor;

public interface UserListsRequestBuilder extends
        PaginationableRequest<UserListsRequestBuilder>,
        ParameterizedRequest<RequestParametersConstructor> {

    UserListsRequestBuilder username(String username);

    UserListsRequest build();
}
