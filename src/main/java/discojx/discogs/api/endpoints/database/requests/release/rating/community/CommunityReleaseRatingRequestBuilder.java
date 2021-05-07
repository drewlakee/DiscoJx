package discojx.discogs.api.endpoints.database.requests.release.rating.community;

import discojx.discogs.api.requests.RequestBuilder;

public interface CommunityReleaseRatingRequestBuilder extends RequestBuilder<CommunityReleaseRatingRequest> {

    CommunityReleaseRatingRequestBuilder releaseId(long releaseId);
}
