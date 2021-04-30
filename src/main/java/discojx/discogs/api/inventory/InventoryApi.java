package discojx.discogs.api.inventory;

import discojx.discogs.api.inventory.upload.InventoryUploadApi;

public interface InventoryApi {

    InventoryUploadApi upload();
}
