package discojx.discogs.api.endpoints.inventory.upload.requests.recent.get;

import discojx.discogs.api.requests.RequestBuilder;

public interface GetUploadRequestBuilder extends RequestBuilder<GetUploadRequest> {

    GetUploadRequestBuilder id(long id);
}
