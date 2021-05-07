package discojx.discogs.api.endpoints.database.requests.release.master;

import discojx.discogs.api.requests.RequestBuilder;

public interface MasterReleaseRequestBuilder extends RequestBuilder<MasterReleaseRequest> {

    MasterReleaseRequestBuilder masterId(long masterId);
}
