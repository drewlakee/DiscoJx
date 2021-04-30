package discojx.discogs.api.inventory.upload.requests.change;

import discojx.requests.RequestBuilder;

import java.nio.file.Path;

public interface ChangeInventoryRequestBuilder extends RequestBuilder<ChangeInventoryRequest> {

    ChangeInventoryRequestBuilder csvFile(Path pathToCsvFile);
}
