package discojx.discogs.api.endpoints.user.identity.requests.profile;

import discojx.discogs.api.requests.RequestBuilder;

public interface ProfileRequestBuilder extends RequestBuilder<ProfileRequest> {

    ProfileRequestBuilder username(String username);
}
