package discojx.discogs.api.endpoints.user.wantlist.requests.edit;

import discojx.discogs.api.requests.RequestBuilder;

public interface EditUserWantListRequestBuilder extends RequestBuilder<EditUserWantListRequest> {

    EditUserWantListRequestBuilder username(String username);
    EditUserWantListRequestBuilder releaseId(long releaseId);
    EditUserWantListRequestBuilder notes(String notes);
    EditUserWantListRequestBuilder rating(int rating);
}
