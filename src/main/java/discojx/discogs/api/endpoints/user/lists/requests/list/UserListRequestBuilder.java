package discojx.discogs.api.endpoints.user.lists.requests.list;

import discojx.discogs.api.requests.RequestBuilder;

public interface UserListRequestBuilder extends RequestBuilder<UserListRequest> {

    UserListRequestBuilder listId(long listId);
}
