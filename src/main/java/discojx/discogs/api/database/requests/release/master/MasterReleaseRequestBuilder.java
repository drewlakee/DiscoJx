package discojx.discogs.api.database.requests.release.master;

public interface MasterReleaseRequestBuilder {

    MasterReleaseRequestBuilder masterId(long masterId);

    MasterReleaseRequest build();
}
