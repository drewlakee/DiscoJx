package discojx.discogs.api.database.requests.label.releases;

import discojx.requests.PaginationableRequest;
import discojx.requests.RequestBuilder;
import discojx.requests.SortableRequest;

public interface LabelReleasesRequestBuilder extends RequestBuilder<LabelReleasesRequest>,
        PaginationableRequest<LabelReleasesRequestBuilder>,
        SortableRequest<LabelReleasesRequestBuilder> {

    LabelReleasesRequestBuilder labelId(long labelId);
}
