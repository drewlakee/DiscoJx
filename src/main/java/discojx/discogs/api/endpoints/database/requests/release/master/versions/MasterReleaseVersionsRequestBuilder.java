package discojx.discogs.api.endpoints.database.requests.release.master.versions;

import discojx.discogs.api.requests.PaginationableRequest;
import discojx.discogs.api.requests.RequestBuilder;
import discojx.discogs.api.requests.SortableRequest;

public interface MasterReleaseVersionsRequestBuilder extends RequestBuilder<MasterReleaseVersionsRequest>,
        PaginationableRequest<MasterReleaseVersionsRequestBuilder>,
        SortableRequest<MasterReleaseVersionsRequestBuilder> {

    MasterReleaseVersionsRequestBuilder masterId(long masterId);
    MasterReleaseVersionsRequestBuilder format(String ... formats);
    MasterReleaseVersionsRequestBuilder label(String ... labels);
    MasterReleaseVersionsRequestBuilder released(int ... years);
    MasterReleaseVersionsRequestBuilder country(String ... countries);
}
