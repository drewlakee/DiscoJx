package discojx.discogs.api.endpoints.inventory.export.requests.recent;

import discojx.discogs.api.requests.PaginationableRequest;
import discojx.discogs.api.requests.RequestBuilder;

public interface GetRecentExportsRequestBuilder extends
        RequestBuilder<GetRecentExportsRequest>,
        PaginationableRequest<GetRecentExportsRequestBuilder> {
}
