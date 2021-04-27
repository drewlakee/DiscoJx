package discojx.discogs.api.user.collection.requests.collection;

public interface UserFoldersRequestBuilder {

    UserFoldersRequestBuilder username(String username);

    UserFoldersRequest build();
}
