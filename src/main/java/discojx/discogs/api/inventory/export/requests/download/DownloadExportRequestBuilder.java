package discojx.discogs.api.inventory.export.requests.download;

import discojx.requests.RequestBuilder;

public interface DownloadExportRequestBuilder extends RequestBuilder<DownloadExportRequest> {

    DownloadExportRequestBuilder id(long id);
}
