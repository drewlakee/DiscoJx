package discojx.discogs.api.endpoints.inventory.upload.requests.delete;

import discojx.discogs.api.requests.RequestBuilder;

import java.nio.file.Path;

public interface DeleteInventoryRequestBuilder extends RequestBuilder<DeleteInventoryRequest> {

    DeleteInventoryRequestBuilder csvFile(Path pathToCsvFile);
}
