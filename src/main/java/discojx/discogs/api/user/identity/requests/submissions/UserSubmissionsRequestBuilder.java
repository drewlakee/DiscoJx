package discojx.discogs.api.user.identity.requests.submissions;

import discojx.requests.PaginationableRequest;
import discojx.requests.RequestBuilder;

public interface UserSubmissionsRequestBuilder extends RequestBuilder<UserSubmissionsRequest>,
        PaginationableRequest<UserSubmissionsRequestBuilder> {

    UserSubmissionsRequestBuilder username(String username);
}
