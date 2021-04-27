package discojx.discogs.api.database.requests.release.rating.community;

import discojx.requests.RequestBuilder;

public interface CommunityReleaseRatingRequestBuilder extends RequestBuilder<CommunityReleaseRatingRequest> {

    CommunityReleaseRatingRequestBuilder releaseId(long releaseId);
}
