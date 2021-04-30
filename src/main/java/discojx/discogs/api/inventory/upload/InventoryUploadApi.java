package discojx.discogs.api.inventory.upload;

import discojx.discogs.api.inventory.upload.requests.add.AddInventoryRequestBuilder;
import discojx.discogs.api.inventory.upload.requests.change.ChangeInventoryRequestBuilder;
import discojx.discogs.api.inventory.upload.requests.delete.DeleteInventoryRequestBuilder;

public interface InventoryUploadApi {

    AddInventoryRequestBuilder add();
    ChangeInventoryRequestBuilder change();
    DeleteInventoryRequestBuilder delete();
}
