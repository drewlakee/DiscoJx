package discojx.discogs.api.inventory.upload;

import discojx.discogs.api.inventory.upload.requests.AddInventoryRequestBuilder;

public interface InventoryUploadApi {

    AddInventoryRequestBuilder add();
}
