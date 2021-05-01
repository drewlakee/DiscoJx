package discojx.discogs.api.inventory.export;

import discojx.discogs.api.inventory.export.requests.download.DownloadExportRequestBuilder;
import discojx.discogs.api.inventory.export.requests.get.GetExportRequestBuilder;
import discojx.discogs.api.inventory.export.requests.recent.GetRecentExportsRequestBuilder;
import discojx.discogs.api.inventory.export.requests.your.ExportYourInventoryRequest;

public interface InventoryExportApi {

    ExportYourInventoryRequest yourInventory();
    GetRecentExportsRequestBuilder getRecentExports();
    GetExportRequestBuilder getExport();
    DownloadExportRequestBuilder downloadExport();
}
