package discojx.discogs.api.user;

import discojx.discogs.api.user.identity.IdentityApi;

public interface UserApi {

    IdentityApi identity();
}
