package discojx.discogs.api.inventory.export.requests.recent;

import discojx.requests.PaginationableRequest;
import discojx.requests.RequestBuilder;

public interface GetRecentExportsRequestBuilder extends
        RequestBuilder<GetRecentExportsRequest>,
        PaginationableRequest<GetRecentExportsRequestBuilder> {
}
