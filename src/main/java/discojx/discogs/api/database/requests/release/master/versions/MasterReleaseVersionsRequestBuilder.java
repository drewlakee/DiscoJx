package discojx.discogs.api.database.requests.release.master.versions;

import discojx.requests.PaginationableRequest;
import discojx.requests.PathParameterizedRequest;
import discojx.requests.SortableRequest;
import discojx.utils.requests.RequestParametersConstructor;

public interface MasterReleaseVersionsRequestBuilder extends
        PaginationableRequest<MasterReleaseVersionsRequestBuilder>,
        SortableRequest<MasterReleaseVersionsRequestBuilder>,
        PathParameterizedRequest<RequestParametersConstructor> {

    MasterReleaseVersionsRequestBuilder masterId(long masterId);
    MasterReleaseVersionsRequestBuilder format(String ... formats);
    MasterReleaseVersionsRequestBuilder label(String ... labels);
    MasterReleaseVersionsRequestBuilder released(int ... years);
    MasterReleaseVersionsRequestBuilder country(String ... countries);

    MasterReleaseVersionsRequest build();
}
