package discojx.discogs.api.endpoints.inventory.export.requests.get;

import discojx.discogs.api.requests.RequestBuilder;

public interface GetExportRequestBuilder extends RequestBuilder<GetExportRequest> {

    GetExportRequestBuilder id(long id);
}
