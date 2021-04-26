package discojx.discogs.api.user.wantlist.requests;

import discojx.requests.PaginationableRequest;
import discojx.requests.PathParameterizedRequest;
import discojx.utils.requests.RequestParametersConstructor;

public interface UserWantListRequestBuilder extends
        PaginationableRequest<UserWantListRequestBuilder>,
        PathParameterizedRequest<RequestParametersConstructor> {

    UserWantListRequestBuilder username(String username);

    UserWantListRequest build();
}
