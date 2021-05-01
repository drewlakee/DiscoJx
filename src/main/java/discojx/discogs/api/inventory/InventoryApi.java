package discojx.discogs.api.inventory;

import discojx.discogs.api.inventory.export.InventoryExportApi;
import discojx.discogs.api.inventory.upload.InventoryUploadApi;

public interface InventoryApi {

    InventoryUploadApi upload();
    InventoryExportApi export();
}
