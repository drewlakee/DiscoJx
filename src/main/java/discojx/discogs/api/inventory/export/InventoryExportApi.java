package discojx.discogs.api.inventory.export;

import discojx.discogs.api.inventory.export.requests.ExportYourInventoryRequest;

public interface InventoryExportApi {

    ExportYourInventoryRequest yourInventory();
}
