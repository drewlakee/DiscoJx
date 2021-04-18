package discojx.discogs.api.user.identity.requests.submissions;

import discojx.requests.PaginationableRequest;

public interface AsyncUserSubmissionsRequestBuilder extends PaginationableRequest<AsyncUserSubmissionsRequestBuilder> {

    AsyncUserSubmissionsRequestBuilder username(String username);

    AsyncUserSubmissionsRequest build();
}
