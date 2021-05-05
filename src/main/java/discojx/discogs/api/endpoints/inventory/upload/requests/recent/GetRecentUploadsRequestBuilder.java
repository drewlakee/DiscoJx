package discojx.discogs.api.endpoints.inventory.upload.requests.recent;

import discojx.discogs.api.requests.PaginationableRequest;
import discojx.discogs.api.requests.RequestBuilder;

public interface GetRecentUploadsRequestBuilder extends RequestBuilder<GetRecentUploadsRequest>,
        PaginationableRequest<GetRecentUploadsRequestBuilder> {
}
