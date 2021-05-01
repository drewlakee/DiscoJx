package discojx.discogs.api.inventory.export.requests.get;

import discojx.requests.RequestBuilder;

public interface GetExportRequestBuilder extends RequestBuilder<GetExportRequest> {

    GetExportRequestBuilder id(long id);
}
