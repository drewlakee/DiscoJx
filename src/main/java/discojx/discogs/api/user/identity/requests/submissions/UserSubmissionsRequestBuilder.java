package discojx.discogs.api.user.identity.requests.submissions;

import discojx.requests.PaginationableRequest;
import discojx.requests.PathParameterizedRequest;
import discojx.utils.requests.RequestParametersConstructor;

public interface UserSubmissionsRequestBuilder extends
        PaginationableRequest<UserSubmissionsRequestBuilder>,
        PathParameterizedRequest<RequestParametersConstructor> {

    UserSubmissionsRequestBuilder username(String username);

    UserSubmissionsRequest build();
}
