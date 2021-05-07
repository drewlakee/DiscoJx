package discojx.discogs.api.endpoints.user.wantlist.requests.add;

import discojx.discogs.api.requests.RequestBuilder;

public interface AddUserWantListRequestBuilder extends RequestBuilder<AddUserWantListRequest> {

    AddUserWantListRequestBuilder username(String username);
    AddUserWantListRequestBuilder releaseId(long releaseId);
    AddUserWantListRequestBuilder notes(String notes);
    AddUserWantListRequestBuilder rating(int rating);
}
