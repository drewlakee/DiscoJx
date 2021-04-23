package discojx.discogs.api.database.requests.release.rating.user.delete;

public interface ReleaseRatingDeleteByUserRequestBuilder {

    ReleaseRatingDeleteByUserRequestBuilder releaseId(long releaseId);
    ReleaseRatingDeleteByUserRequestBuilder username(String username);

    ReleaseRatingDeleteByUserRequest build();
}
