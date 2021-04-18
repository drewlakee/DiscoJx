package discojx.discogs.api.database.requests.release.rating.user.edit;

public interface AsyncReleaseRatingUpdateByUserRequestBuilder {

    AsyncReleaseRatingUpdateByUserRequestBuilder releaseId(long releaseId);
    AsyncReleaseRatingUpdateByUserRequestBuilder username(String username);
    AsyncReleaseRatingUpdateByUserRequestBuilder rating(int rating);

    AsyncReleaseRatingUpdateByUserRequest build();
}
