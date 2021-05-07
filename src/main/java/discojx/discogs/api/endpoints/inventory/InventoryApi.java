package discojx.discogs.api.endpoints.inventory;

import discojx.discogs.api.endpoints.inventory.export.InventoryExportApi;
import discojx.discogs.api.endpoints.inventory.upload.InventoryUploadApi;

public interface InventoryApi {

    InventoryUploadApi upload();
    InventoryExportApi export();
}
