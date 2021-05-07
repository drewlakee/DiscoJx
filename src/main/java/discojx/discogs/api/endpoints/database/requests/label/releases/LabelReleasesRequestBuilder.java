package discojx.discogs.api.endpoints.database.requests.label.releases;

import discojx.discogs.api.requests.PaginationableRequest;
import discojx.discogs.api.requests.RequestBuilder;
import discojx.discogs.api.requests.SortableRequest;

public interface LabelReleasesRequestBuilder extends RequestBuilder<LabelReleasesRequest>,
        PaginationableRequest<LabelReleasesRequestBuilder>,
        SortableRequest<LabelReleasesRequestBuilder> {

    LabelReleasesRequestBuilder labelId(long labelId);
}
