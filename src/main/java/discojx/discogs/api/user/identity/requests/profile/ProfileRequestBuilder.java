package discojx.discogs.api.user.identity.requests.profile;

import discojx.requests.RequestBuilder;

public interface ProfileRequestBuilder extends RequestBuilder<ProfileRequest> {

    ProfileRequestBuilder username(String username);
}
