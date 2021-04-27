package discojx.discogs.api.user.collection.requests.collection.folder.edit;

import com.fasterxml.jackson.databind.node.ObjectNode;
import discojx.requests.JsonParameterizedRequest;

public interface EditUserFolderRequestBuilder extends JsonParameterizedRequest<ObjectNode> {

    EditUserFolderRequestBuilder username(String username);
    EditUserFolderRequestBuilder folderId(long folderId);
    EditUserFolderRequestBuilder name(String name);

    EditUserFolderRequest build();
}
