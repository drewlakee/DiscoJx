package discojx.discogs.api.user.wantlist.requests.delete;

import discojx.requests.RequestBuilder;

public interface DeleteUserWantListRequestBuilder extends RequestBuilder<DeleteUserWantListRequest> {

    DeleteUserWantListRequestBuilder username(String username);
    DeleteUserWantListRequestBuilder releaseId(long releaseId);
}
