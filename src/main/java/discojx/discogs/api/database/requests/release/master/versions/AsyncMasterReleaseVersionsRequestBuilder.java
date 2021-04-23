package discojx.discogs.api.database.requests.release.master.versions;

import discojx.requests.PaginationableRequest;
import discojx.requests.ParameterizedRequest;
import discojx.requests.SortableRequest;
import discojx.utils.requests.RequestParametersConstructor;

public interface AsyncMasterReleaseVersionsRequestBuilder extends
        PaginationableRequest<AsyncMasterReleaseVersionsRequestBuilder>,
        SortableRequest<AsyncMasterReleaseVersionsRequestBuilder>,
        ParameterizedRequest<RequestParametersConstructor> {

    AsyncMasterReleaseVersionsRequestBuilder masterId(long masterId);
    AsyncMasterReleaseVersionsRequestBuilder format(String ... formats);
    AsyncMasterReleaseVersionsRequestBuilder label(String ... labels);
    AsyncMasterReleaseVersionsRequestBuilder released(int ... years);
    AsyncMasterReleaseVersionsRequestBuilder country(String ... countries);

    AsyncMasterReleaseVersionsRequest build();
}
