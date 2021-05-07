package discojx.discogs.api.endpoints.user.identity.requests.contributions;

import discojx.discogs.api.requests.PaginationableRequest;
import discojx.discogs.api.requests.RequestBuilder;
import discojx.discogs.api.requests.SortableRequest;

public interface UserContributionsRequestBuilder extends RequestBuilder<UserContributionsRequest>,
        PaginationableRequest<UserContributionsRequestBuilder>,
        SortableRequest<UserContributionsRequestBuilder> {

    UserContributionsRequestBuilder username(String username);
}
