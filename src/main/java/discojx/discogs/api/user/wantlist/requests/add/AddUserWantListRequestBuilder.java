package discojx.discogs.api.user.wantlist.requests.add;

import com.fasterxml.jackson.databind.node.ObjectNode;
import discojx.requests.JsonParameterizedRequest;

public interface AddUserWantListRequestBuilder extends JsonParameterizedRequest<ObjectNode> {

    AddUserWantListRequestBuilder username(String username);
    AddUserWantListRequestBuilder releaseId(long releaseId);
    AddUserWantListRequestBuilder notes(String notes);
    AddUserWantListRequestBuilder rating(int rating);

    AddUserWantListRequest build();
}
