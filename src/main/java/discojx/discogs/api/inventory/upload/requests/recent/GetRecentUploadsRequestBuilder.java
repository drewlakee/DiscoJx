package discojx.discogs.api.inventory.upload.requests.recent;

import discojx.requests.PaginationableRequest;
import discojx.requests.RequestBuilder;

public interface GetRecentUploadsRequestBuilder extends RequestBuilder<GetRecentUploadsRequest>,
        PaginationableRequest<GetRecentUploadsRequestBuilder> {
}
