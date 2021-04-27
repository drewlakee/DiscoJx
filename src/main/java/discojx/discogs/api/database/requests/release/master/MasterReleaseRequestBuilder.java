package discojx.discogs.api.database.requests.release.master;

import discojx.requests.RequestBuilder;

public interface MasterReleaseRequestBuilder extends RequestBuilder<MasterReleaseRequest> {

    MasterReleaseRequestBuilder masterId(long masterId);
}
