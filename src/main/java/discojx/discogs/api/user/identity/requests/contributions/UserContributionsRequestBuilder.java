package discojx.discogs.api.user.identity.requests.contributions;

import discojx.requests.PaginationableRequest;
import discojx.requests.RequestBuilder;
import discojx.requests.SortableRequest;

public interface UserContributionsRequestBuilder extends RequestBuilder<UserContributionsRequest>,
        PaginationableRequest<UserContributionsRequestBuilder>,
        SortableRequest<UserContributionsRequestBuilder> {

    UserContributionsRequestBuilder username(String username);
}
