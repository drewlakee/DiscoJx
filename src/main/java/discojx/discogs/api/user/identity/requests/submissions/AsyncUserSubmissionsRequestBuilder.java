package discojx.discogs.api.user.identity.requests.submissions;

import discojx.requests.PaginationableRequest;
import discojx.requests.ParameterizedRequest;

public interface AsyncUserSubmissionsRequestBuilder extends
        PaginationableRequest<AsyncUserSubmissionsRequestBuilder>,
        ParameterizedRequest<String> {

    AsyncUserSubmissionsRequestBuilder username(String username);

    AsyncUserSubmissionsRequest build();
}
