package discojx.discogs.api.database.requests.release.rating.user;

public interface ReleaseRatingByUserRequestBuilder {

    ReleaseRatingByUserRequestBuilder releaseId(long releaseId);
    ReleaseRatingByUserRequestBuilder username(String username);

    ReleaseRatingByUserRequest build();
}
