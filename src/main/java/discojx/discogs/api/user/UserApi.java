package discojx.discogs.api.user;

import discojx.discogs.api.user.identity.IdentityApi;
import discojx.discogs.api.user.lists.UserListsApi;

public interface UserApi {

    IdentityApi identity();
    UserListsApi userLists();
}
