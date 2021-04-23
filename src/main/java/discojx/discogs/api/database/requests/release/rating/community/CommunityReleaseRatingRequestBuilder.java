package discojx.discogs.api.database.requests.release.rating.community;

public interface CommunityReleaseRatingRequestBuilder {

    CommunityReleaseRatingRequestBuilder releaseId(long releaseId);

    CommunityReleaseRatingRequest build();
}
