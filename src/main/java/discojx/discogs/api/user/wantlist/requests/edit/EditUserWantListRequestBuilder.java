package discojx.discogs.api.user.wantlist.requests.edit;

import com.fasterxml.jackson.databind.node.ObjectNode;
import discojx.requests.JsonParameterizedRequest;

public interface EditUserWantListRequestBuilder extends JsonParameterizedRequest<ObjectNode> {

    EditUserWantListRequestBuilder username(String username);
    EditUserWantListRequestBuilder releaseId(long releaseId);
    EditUserWantListRequestBuilder notes(String notes);
    EditUserWantListRequestBuilder rating(int rating);

    EditUserWantListRequest build();
}
