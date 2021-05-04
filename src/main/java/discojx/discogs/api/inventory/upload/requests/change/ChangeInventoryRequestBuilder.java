package discojx.discogs.api.inventory.upload.requests.change;

import discojx.requests.RequestBuilder;

import java.io.InputStream;
import java.nio.file.Path;

public interface ChangeInventoryRequestBuilder extends RequestBuilder<ChangeInventoryRequest> {

    ChangeInventoryRequestBuilder csvFile(Path pathToCsvFile);
    ChangeInventoryRequestBuilder csvFile(InputStream csvFileInputStream);
}
