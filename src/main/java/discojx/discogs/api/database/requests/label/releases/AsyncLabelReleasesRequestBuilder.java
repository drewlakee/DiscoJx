package discojx.discogs.api.database.requests.label.releases;

import discojx.requests.PaginationableRequest;
import discojx.requests.ParameterizedRequest;
import discojx.requests.SortableRequest;
import discojx.utils.requests.RequestParametersConstructor;

public interface AsyncLabelReleasesRequestBuilder extends
        PaginationableRequest<AsyncLabelReleasesRequestBuilder>,
        SortableRequest<AsyncLabelReleasesRequestBuilder>,
        ParameterizedRequest<RequestParametersConstructor> {

    AsyncLabelReleasesRequestBuilder labelId(long labelId);

    AsyncLabelReleasesRequest build();
}
