package discojx.discogs.api.endpoints.user.wantlist;

import discojx.discogs.api.endpoints.user.wantlist.requests.UserWantListRequestBuilder;
import discojx.discogs.api.endpoints.user.wantlist.requests.add.AddUserWantListRequestBuilder;
import discojx.discogs.api.endpoints.user.wantlist.requests.delete.DeleteUserWantListRequestBuilder;
import discojx.discogs.api.endpoints.user.wantlist.requests.edit.EditUserWantListRequestBuilder;

public interface UserWantListApi {

    UserWantListRequestBuilder getWantList();
    AddUserWantListRequestBuilder addWantList();
    EditUserWantListRequestBuilder editWantList();
    DeleteUserWantListRequestBuilder deleteWantList();
}
