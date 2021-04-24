package discojx.discogs.api.user.lists.requests.list;

public interface UserListRequestBuilder {

    UserListRequestBuilder listId(long listId);

    UserListRequest build();
}
