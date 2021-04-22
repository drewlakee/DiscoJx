package discojx.discogs.api.user.identity.requests.contributions;

import discojx.requests.PaginationableRequest;
import discojx.requests.ParameterizedRequest;
import discojx.requests.SortableRequest;

public interface AsyncUserContributionsRequestBuilder extends
        PaginationableRequest<AsyncUserContributionsRequestBuilder>,
        SortableRequest<AsyncUserContributionsRequestBuilder>,
        ParameterizedRequest<String> {

    AsyncUserContributionsRequestBuilder username(String username);

    AsyncUserContributionsRequest build();
}
