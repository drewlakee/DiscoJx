package discojx.discogs.api.inventory.upload.requests.delete;

import discojx.requests.RequestBuilder;

import java.nio.file.Path;

public interface DeleteInventoryRequestBuilder extends RequestBuilder<DeleteInventoryRequest> {

    DeleteInventoryRequestBuilder csvFile(Path pathToCsvFile);
}
