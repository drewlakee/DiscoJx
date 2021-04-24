package discojx.discogs.api.database.requests.release.rating.user.edit;

import com.fasterxml.jackson.databind.node.ObjectNode;
import discojx.requests.JsonParameterizedRequest;

public interface ReleaseRatingUpdateByUserRequestBuilder extends JsonParameterizedRequest<ObjectNode> {

    ReleaseRatingUpdateByUserRequestBuilder releaseId(long releaseId);
    ReleaseRatingUpdateByUserRequestBuilder username(String username);
    ReleaseRatingUpdateByUserRequestBuilder rating(int rating);

    ReleaseRatingUpdateByUserRequest build();
}
