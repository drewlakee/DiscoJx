package discojx.discogs.api.database.requests.release.stats;

import discojx.requests.RequestBuilder;

public interface ReleaseStatsRequestBuilder extends RequestBuilder<ReleaseStatsRequest> {

    ReleaseStatsRequestBuilder releaseId(long releaseId);

    ReleaseStatsRequest build();
}
