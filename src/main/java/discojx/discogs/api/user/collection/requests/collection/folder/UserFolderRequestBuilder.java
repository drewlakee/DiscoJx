package discojx.discogs.api.user.collection.requests.collection.folder;

public interface UserFolderRequestBuilder {

    UserFolderRequestBuilder username(String username);
    UserFolderRequestBuilder folderId(long folderId);

    UserFolderRequest build();
}
