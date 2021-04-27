package discojx.discogs.api.user.collection.requests.collection.folder.edit;

import discojx.requests.RequestBuilder;

public interface EditUserFolderRequestBuilder extends RequestBuilder<EditUserFolderRequest> {

    EditUserFolderRequestBuilder username(String username);
    EditUserFolderRequestBuilder folderId(long folderId);
    EditUserFolderRequestBuilder name(String name);
}
