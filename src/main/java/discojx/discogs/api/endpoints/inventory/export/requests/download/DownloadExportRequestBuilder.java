package discojx.discogs.api.endpoints.inventory.export.requests.download;

import discojx.discogs.api.requests.RequestBuilder;

public interface DownloadExportRequestBuilder extends RequestBuilder<DownloadExportRequest> {

    DownloadExportRequestBuilder id(long id);
}
