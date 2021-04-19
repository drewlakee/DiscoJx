package discojx.discogs.api.database.requests.release.master;

public interface AsyncMasterReleaseRequestBuilder {

    AsyncMasterReleaseRequestBuilder masterId(long masterId);

    AsyncMasterReleaseRequest build();
}
