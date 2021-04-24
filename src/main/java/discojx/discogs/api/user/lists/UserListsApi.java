package discojx.discogs.api.user.lists;

import discojx.discogs.api.user.lists.requests.UserListsRequestBuilder;
import discojx.discogs.api.user.lists.requests.list.UserListRequestBuilder;

public interface UserListsApi {

    UserListsRequestBuilder lists();
    UserListRequestBuilder list();
}
