package discojx.discogs.api.endpoints.user.lists;

import discojx.discogs.api.endpoints.user.lists.requests.UserListsRequestBuilder;
import discojx.discogs.api.endpoints.user.lists.requests.list.UserListRequestBuilder;

public interface UserListsApi {

    UserListsRequestBuilder getLists();
    UserListRequestBuilder getList();
}
