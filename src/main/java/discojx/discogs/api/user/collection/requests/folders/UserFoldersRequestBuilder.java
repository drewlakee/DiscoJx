package discojx.discogs.api.user.collection.requests.folders;

public interface UserFoldersRequestBuilder {

    UserFoldersRequestBuilder username(String username);

    UserFoldersRequest build();
}
