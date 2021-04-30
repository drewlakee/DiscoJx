package discojx.discogs.api.inventory.upload.requests.add;

import discojx.requests.RequestBuilder;

import java.nio.file.Path;

public interface AddInventoryRequestBuilder extends RequestBuilder<AddInventoryRequest> {

    AddInventoryRequestBuilder csvFile(Path pathToCsvFile);
}
