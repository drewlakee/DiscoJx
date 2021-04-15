package discojx.discogs.api.user.identity;

import discojx.discogs.api.user.identity.requests.AsyncUserIdentityRequest;
import discojx.discogs.api.user.identity.requests.profile.AsyncProfileRequestBuilder;

public interface AsyncIdentityApi {

    AsyncUserIdentityRequest self();
    AsyncProfileRequestBuilder profile();
}
