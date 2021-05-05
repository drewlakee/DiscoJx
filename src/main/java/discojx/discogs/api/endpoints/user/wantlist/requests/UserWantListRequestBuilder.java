package discojx.discogs.api.endpoints.user.wantlist.requests;

import discojx.discogs.api.requests.PaginationableRequest;
import discojx.discogs.api.requests.RequestBuilder;

public interface UserWantListRequestBuilder extends RequestBuilder<UserWantListRequest>,
        PaginationableRequest<UserWantListRequestBuilder> {

    UserWantListRequestBuilder username(String username);
}
