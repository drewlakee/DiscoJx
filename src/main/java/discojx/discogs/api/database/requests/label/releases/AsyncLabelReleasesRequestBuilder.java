package discojx.discogs.api.database.requests.label.releases;

import discojx.requests.PaginationableRequest;
import discojx.requests.ParameterizedRequest;
import discojx.requests.SortableRequest;

public interface AsyncLabelReleasesRequestBuilder extends
        PaginationableRequest<AsyncLabelReleasesRequestBuilder>,
        SortableRequest<AsyncLabelReleasesRequestBuilder>,
        ParameterizedRequest<String> {

    AsyncLabelReleasesRequestBuilder labelId(long labelId);

    AsyncLabelReleasesRequest build();
}
