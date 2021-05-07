package discojx.discogs.api.endpoints.database.requests.release.stats;

import discojx.discogs.api.requests.RequestBuilder;

public interface ReleaseStatsRequestBuilder extends RequestBuilder<ReleaseStatsRequest> {

    ReleaseStatsRequestBuilder releaseId(long releaseId);

    ReleaseStatsRequest build();
}
