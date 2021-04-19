package discojx.discogs.api.user.identity.requests.contributions;

import discojx.requests.PaginationableRequest;
import discojx.requests.SortableRequest;

public interface AsyncUserContributionsRequestBuilder extends PaginationableRequest<AsyncUserContributionsRequestBuilder>, SortableRequest<AsyncUserContributionsRequestBuilder> {

    AsyncUserContributionsRequestBuilder username(String username);

    AsyncUserContributionsRequest build();
}
