package discojx.discogs.api.endpoints.inventory.upload.requests.change;

import discojx.discogs.api.requests.RequestBuilder;

import java.io.InputStream;
import java.nio.file.Path;

public interface ChangeInventoryRequestBuilder extends RequestBuilder<ChangeInventoryRequest> {

    ChangeInventoryRequestBuilder csvFile(Path pathToCsvFile);
    ChangeInventoryRequestBuilder csvFile(InputStream csvFileInputStream);
}
