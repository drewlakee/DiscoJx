package discojx.discogs.api.user.identity.requests.profile;

public interface AsyncProfileRequestBuilder {

    AsyncProfileRequestBuilder username(String username);

    AsyncProfileRequest build();
}
