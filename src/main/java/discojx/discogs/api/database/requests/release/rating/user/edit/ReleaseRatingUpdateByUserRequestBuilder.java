package discojx.discogs.api.database.requests.release.rating.user.edit;

public interface ReleaseRatingUpdateByUserRequestBuilder {

    ReleaseRatingUpdateByUserRequestBuilder releaseId(long releaseId);
    ReleaseRatingUpdateByUserRequestBuilder username(String username);
    ReleaseRatingUpdateByUserRequestBuilder rating(int rating);

    ReleaseRatingUpdateByUserRequest build();
}
