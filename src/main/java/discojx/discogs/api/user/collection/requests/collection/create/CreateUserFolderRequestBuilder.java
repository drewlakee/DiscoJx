package discojx.discogs.api.user.collection.requests.collection.create;

import com.fasterxml.jackson.databind.node.ObjectNode;
import discojx.requests.JsonParameterizedRequest;

public interface CreateUserFolderRequestBuilder extends JsonParameterizedRequest<ObjectNode> {

    CreateUserFolderRequestBuilder username(String username);
    CreateUserFolderRequestBuilder name(String name);

    CreateUserFolderRequest build();
}
