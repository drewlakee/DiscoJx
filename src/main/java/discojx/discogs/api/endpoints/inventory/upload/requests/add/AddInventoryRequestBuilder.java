package discojx.discogs.api.endpoints.inventory.upload.requests.add;

import discojx.discogs.api.requests.RequestBuilder;

import java.io.InputStream;
import java.nio.file.Path;

public interface AddInventoryRequestBuilder extends RequestBuilder<AddInventoryRequest> {

    AddInventoryRequestBuilder csvFile(Path pathToCsvFile);
    AddInventoryRequestBuilder csvFile(InputStream csvFileInputStream);
}
