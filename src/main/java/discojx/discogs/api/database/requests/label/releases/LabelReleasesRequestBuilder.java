package discojx.discogs.api.database.requests.label.releases;

import discojx.requests.PaginationableRequest;
import discojx.requests.PathParameterizedRequest;
import discojx.requests.SortableRequest;
import discojx.utils.requests.RequestParametersConstructor;

public interface LabelReleasesRequestBuilder extends
        PaginationableRequest<LabelReleasesRequestBuilder>,
        SortableRequest<LabelReleasesRequestBuilder>,
        PathParameterizedRequest<RequestParametersConstructor> {

    LabelReleasesRequestBuilder labelId(long labelId);

    LabelReleasesRequest build();
}
