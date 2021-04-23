package discojx.discogs.api.user.identity.requests.submissions;

import discojx.requests.PaginationableRequest;
import discojx.requests.ParameterizedRequest;
import discojx.utils.requests.RequestParametersConstructor;

public interface AsyncUserSubmissionsRequestBuilder extends
        PaginationableRequest<AsyncUserSubmissionsRequestBuilder>,
        ParameterizedRequest<RequestParametersConstructor> {

    AsyncUserSubmissionsRequestBuilder username(String username);

    AsyncUserSubmissionsRequest build();
}
