package discojx.discogs.api.database.requests.release.stats;

public interface AsyncReleaseStatsRequestBuilder {

    AsyncReleaseStatsRequestBuilder releaseId(long releaseId);

    AsyncReleaseStatsRequest build();
}
