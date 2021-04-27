package discojx.discogs.api.user.collection.requests.collection.folder.delete;

public interface DeleteUserFolderRequestBuilder {

    DeleteUserFolderRequestBuilder username(String username);
    DeleteUserFolderRequestBuilder folderId(long folderId);

    DeleteUserFolderRequest build();
}
