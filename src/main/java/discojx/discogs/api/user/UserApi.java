package discojx.discogs.api.user;

import discojx.discogs.api.user.collection.UserCollectionApi;
import discojx.discogs.api.user.identity.IdentityApi;
import discojx.discogs.api.user.lists.UserListsApi;
import discojx.discogs.api.user.wantlist.UserWantListApi;

public interface UserApi {

    IdentityApi identity();
    UserListsApi lists();
    UserWantListApi wantList();
    UserCollectionApi collection();
}
