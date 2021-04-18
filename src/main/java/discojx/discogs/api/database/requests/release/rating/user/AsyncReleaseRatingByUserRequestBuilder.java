package discojx.discogs.api.database.requests.release.rating.user;

public interface AsyncReleaseRatingByUserRequestBuilder {

    AsyncReleaseRatingByUserRequestBuilder releaseId(long releaseId);
    AsyncReleaseRatingByUserRequestBuilder username(String username);

    AsyncReleaseRatingByUserRequest build();
}
