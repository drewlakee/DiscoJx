package discojx.discogs.api.user.identity.requests.contributions;

import discojx.requests.PaginationableRequest;

public interface AsyncUserContributionsRequestBuilder extends PaginationableRequest<AsyncUserContributionsRequestBuilder> {

    AsyncUserContributionsRequestBuilder username(String username);
    AsyncUserContributionsRequestBuilder sort(String attribute);
    AsyncUserContributionsRequestBuilder sortOrder(String sortOrder);

    AsyncUserContributionsRequest build();
}
