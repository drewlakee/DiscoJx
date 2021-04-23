package discojx.discogs.api.user.identity.requests.profile;

public interface ProfileRequestBuilder {

    ProfileRequestBuilder username(String username);

    ProfileRequest build();
}
