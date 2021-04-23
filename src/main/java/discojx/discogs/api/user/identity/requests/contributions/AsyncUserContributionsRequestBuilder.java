package discojx.discogs.api.user.identity.requests.contributions;

import discojx.requests.PaginationableRequest;
import discojx.requests.ParameterizedRequest;
import discojx.requests.SortableRequest;
import discojx.utils.requests.RequestParametersConstructor;

public interface AsyncUserContributionsRequestBuilder extends
        PaginationableRequest<AsyncUserContributionsRequestBuilder>,
        SortableRequest<AsyncUserContributionsRequestBuilder>,
        ParameterizedRequest<RequestParametersConstructor> {

    AsyncUserContributionsRequestBuilder username(String username);

    AsyncUserContributionsRequest build();
}
