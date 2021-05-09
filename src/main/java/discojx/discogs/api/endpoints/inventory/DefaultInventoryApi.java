package discojx.discogs.api.endpoints.inventory;

import discojx.http.AbstractHttpClient;
import discojx.discogs.api.endpoints.inventory.export.DefaultInventoryExportApi;
import discojx.discogs.api.endpoints.inventory.export.InventoryExportApi;
import discojx.discogs.api.endpoints.inventory.upload.DefaultInventoryUploadApi;
import discojx.discogs.api.endpoints.inventory.upload.InventoryUploadApi;

import java.util.Objects;

public class DefaultInventoryApi implements InventoryApi {

    protected final InventoryUploadApi uploadApi;
    protected final InventoryExportApi exportApi;

    public DefaultInventoryApi(AbstractHttpClient client) {
        this.uploadApi = new DefaultInventoryUploadApi(client);
        this.exportApi = new DefaultInventoryExportApi(client);
    }

    @Override
    public InventoryUploadApi upload() {
        return uploadApi;
    }

    @Override
    public InventoryExportApi export() {
        return exportApi;
    }

    @Override
    public String toString() {
        return "DefaultInventoryApi{" +
                "uploadApi=" + uploadApi +
                ", exportApi=" + exportApi +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultInventoryApi that = (DefaultInventoryApi) o;
        return Objects.equals(uploadApi, that.uploadApi) && Objects.equals(exportApi, that.exportApi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uploadApi, exportApi);
    }
}
