package discojx.discogs.api.user.lists.requests.list;

import discojx.requests.RequestBuilder;

public interface UserListRequestBuilder extends RequestBuilder<UserListRequest> {

    UserListRequestBuilder listId(long listId);
}
