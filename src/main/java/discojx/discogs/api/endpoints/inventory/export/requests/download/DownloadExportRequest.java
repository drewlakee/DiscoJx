package discojx.discogs.api.endpoints.inventory.export.requests.download;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.utils.files.FileResponseWrapper;

public interface DownloadExportRequest extends AsyncExecutableRequest<FileResponseWrapper> {
}
