package discojx.discogs.api.inventory.upload;

import discojx.discogs.api.inventory.upload.requests.add.AddInventoryRequestBuilder;
import discojx.discogs.api.inventory.upload.requests.change.ChangeInventoryRequestBuilder;
import discojx.discogs.api.inventory.upload.requests.delete.DeleteInventoryRequestBuilder;
import discojx.discogs.api.inventory.upload.requests.recent.GetRecentUploadsRequestBuilder;
import discojx.discogs.api.inventory.upload.requests.recent.get.GetUploadRequestBuilder;

public interface InventoryUploadApi {

    AddInventoryRequestBuilder add();
    ChangeInventoryRequestBuilder change();
    DeleteInventoryRequestBuilder delete();
    GetRecentUploadsRequestBuilder getRecentUploads();
    GetUploadRequestBuilder getUpload();
}
