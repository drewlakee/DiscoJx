package discojx.discogs.api.endpoints.user;

import discojx.discogs.api.endpoints.user.collection.UserCollectionApi;
import discojx.discogs.api.endpoints.user.identity.IdentityApi;
import discojx.discogs.api.endpoints.user.lists.UserListsApi;
import discojx.discogs.api.endpoints.user.wantlist.UserWantListApi;

public interface UserApi {

    IdentityApi identity();
    UserListsApi lists();
    UserWantListApi wantList();
    UserCollectionApi collection();
}
