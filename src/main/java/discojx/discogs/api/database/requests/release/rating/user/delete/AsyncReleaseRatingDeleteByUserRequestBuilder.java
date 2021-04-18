package discojx.discogs.api.database.requests.release.rating.user.delete;

public interface AsyncReleaseRatingDeleteByUserRequestBuilder {

    AsyncReleaseRatingDeleteByUserRequestBuilder releaseId(long releaseId);
    AsyncReleaseRatingDeleteByUserRequestBuilder username(String username);

    AsyncReleaseRatingDeleteByUserRequest build();
}
