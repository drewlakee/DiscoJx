package discojx.discogs.api.endpoints.user.wantlist.requests.delete;

import discojx.discogs.api.requests.RequestBuilder;

public interface DeleteUserWantListRequestBuilder extends RequestBuilder<DeleteUserWantListRequest> {

    DeleteUserWantListRequestBuilder username(String username);
    DeleteUserWantListRequestBuilder releaseId(long releaseId);
}
