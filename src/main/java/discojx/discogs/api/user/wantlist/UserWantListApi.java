package discojx.discogs.api.user.wantlist;

import discojx.discogs.api.user.wantlist.requests.UserWantListRequestBuilder;
import discojx.discogs.api.user.wantlist.requests.add.AddUserWantListRequestBuilder;
import discojx.discogs.api.user.wantlist.requests.edit.EditUserWantListRequestBuilder;

public interface UserWantListApi {

    UserWantListRequestBuilder wantList();
    AddUserWantListRequestBuilder addWantList();
    EditUserWantListRequestBuilder editWantList();
}
