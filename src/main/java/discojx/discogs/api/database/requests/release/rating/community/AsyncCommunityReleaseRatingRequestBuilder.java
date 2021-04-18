package discojx.discogs.api.database.requests.release.rating.community;

public interface AsyncCommunityReleaseRatingRequestBuilder {

    AsyncCommunityReleaseRatingRequestBuilder releaseId(long releaseId);

    AsyncCommunityReleaseRatingRequest build();
}
