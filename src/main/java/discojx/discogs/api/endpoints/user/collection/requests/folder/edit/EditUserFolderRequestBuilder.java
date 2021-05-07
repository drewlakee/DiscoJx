package discojx.discogs.api.endpoints.user.collection.requests.folder.edit;

import discojx.discogs.api.requests.RequestBuilder;

public interface EditUserFolderRequestBuilder extends RequestBuilder<EditUserFolderRequest> {

    EditUserFolderRequestBuilder username(String username);
    EditUserFolderRequestBuilder folderId(long folderId);
    EditUserFolderRequestBuilder name(String name);
}
