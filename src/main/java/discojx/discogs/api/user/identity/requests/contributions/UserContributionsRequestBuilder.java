package discojx.discogs.api.user.identity.requests.contributions;

import discojx.requests.PaginationableRequest;
import discojx.requests.PathParameterizedRequest;
import discojx.requests.SortableRequest;
import discojx.utils.requests.RequestParametersConstructor;

public interface UserContributionsRequestBuilder extends
        PaginationableRequest<UserContributionsRequestBuilder>,
        SortableRequest<UserContributionsRequestBuilder>,
        PathParameterizedRequest<RequestParametersConstructor> {

    UserContributionsRequestBuilder username(String username);

    UserContributionsRequest build();
}
