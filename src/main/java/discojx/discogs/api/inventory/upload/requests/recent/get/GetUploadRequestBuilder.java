package discojx.discogs.api.inventory.upload.requests.recent.get;

import discojx.requests.RequestBuilder;

public interface GetUploadRequestBuilder extends RequestBuilder<GetUploadRequest> {

    GetUploadRequestBuilder id(long id);
}
