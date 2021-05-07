package discojx.discogs.api.endpoints.user.identity.requests.submissions;

import discojx.discogs.api.requests.PaginationableRequest;
import discojx.discogs.api.requests.RequestBuilder;

public interface UserSubmissionsRequestBuilder extends RequestBuilder<UserSubmissionsRequest>,
        PaginationableRequest<UserSubmissionsRequestBuilder> {

    UserSubmissionsRequestBuilder username(String username);
}
