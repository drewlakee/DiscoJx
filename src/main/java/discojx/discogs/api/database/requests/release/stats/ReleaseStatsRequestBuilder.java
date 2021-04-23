package discojx.discogs.api.database.requests.release.stats;

public interface ReleaseStatsRequestBuilder {

    ReleaseStatsRequestBuilder releaseId(long releaseId);

    ReleaseStatsRequest build();
}
