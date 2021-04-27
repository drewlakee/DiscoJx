package discojx.discogs.api.database.requests.release.master.versions;

import discojx.requests.PaginationableRequest;
import discojx.requests.RequestBuilder;
import discojx.requests.SortableRequest;

public interface MasterReleaseVersionsRequestBuilder extends RequestBuilder<MasterReleaseVersionsRequest>,
        PaginationableRequest<MasterReleaseVersionsRequestBuilder>,
        SortableRequest<MasterReleaseVersionsRequestBuilder> {

    MasterReleaseVersionsRequestBuilder masterId(long masterId);
    MasterReleaseVersionsRequestBuilder format(String ... formats);
    MasterReleaseVersionsRequestBuilder label(String ... labels);
    MasterReleaseVersionsRequestBuilder released(int ... years);
    MasterReleaseVersionsRequestBuilder country(String ... countries);
}
