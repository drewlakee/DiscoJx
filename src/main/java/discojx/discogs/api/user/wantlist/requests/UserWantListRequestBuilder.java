package discojx.discogs.api.user.wantlist.requests;

import discojx.requests.PaginationableRequest;
import discojx.requests.RequestBuilder;

public interface UserWantListRequestBuilder extends RequestBuilder<UserWantListRequest>,
        PaginationableRequest<UserWantListRequestBuilder> {

    UserWantListRequestBuilder username(String username);
}
