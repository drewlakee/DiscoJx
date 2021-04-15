package discojx.discogs.api.user;

import discojx.discogs.api.user.identity.AsyncIdentityApi;

public interface AsyncUserApi {

    AsyncIdentityApi identity();
}
