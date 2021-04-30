package discojx.discogs.api.inventory;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.inventory.upload.DefaultInventoryUploadApi;
import discojx.discogs.api.inventory.upload.InventoryUploadApi;
import org.apache.http.HttpEntity;

import java.util.Objects;

public class DefaultInventoryApi implements InventoryApi {

    protected final InventoryUploadApi uploadApi;

    public DefaultInventoryApi(AbstractHttpClient client) {
        this.uploadApi = new DefaultInventoryUploadApi(client);
    }

    @Override
    public InventoryUploadApi upload() {
        return uploadApi;
    }

    @Override
    public String toString() {
        return "DefaultInventoryApi{" +
                "uploadApi=" + uploadApi +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultInventoryApi that = (DefaultInventoryApi) o;
        return Objects.equals(uploadApi, that.uploadApi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uploadApi);
    }
}
