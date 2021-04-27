package discojx.discogs.api.user.wantlist.requests.add;

import discojx.requests.RequestBuilder;

public interface AddUserWantListRequestBuilder extends RequestBuilder<AddUserWantListRequest> {

    AddUserWantListRequestBuilder username(String username);
    AddUserWantListRequestBuilder releaseId(long releaseId);
    AddUserWantListRequestBuilder notes(String notes);
    AddUserWantListRequestBuilder rating(int rating);
}
