package discojx.discogs.api.endpoints.inventory.upload;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.endpoints.inventory.upload.requests.add.AddInventoryRequestBuilder;
import discojx.discogs.api.requests.impl.DefaultAddInventoryRequest;
import discojx.discogs.api.endpoints.inventory.upload.requests.change.ChangeInventoryRequestBuilder;
import discojx.discogs.api.requests.impl.DefaultChangeInventoryRequest;
import discojx.discogs.api.requests.impl.DefaultDeleteInventoryRequest;
import discojx.discogs.api.endpoints.inventory.upload.requests.delete.DeleteInventoryRequestBuilder;
import discojx.discogs.api.requests.impl.DefaultGetRecentUploadsRequest;
import discojx.discogs.api.endpoints.inventory.upload.requests.recent.GetRecentUploadsRequestBuilder;
import discojx.discogs.api.requests.impl.DefaultGetUploadRequest;
import discojx.discogs.api.endpoints.inventory.upload.requests.recent.get.GetUploadRequestBuilder;

import java.util.Objects;

public class DefaultInventoryUploadApi implements InventoryUploadApi {

    protected final AbstractHttpClient client;

    public DefaultInventoryUploadApi(AbstractHttpClient client) {
        this.client = client;
    }

    @Override
    public AddInventoryRequestBuilder addInventory() {
        return new DefaultAddInventoryRequest.Builder(client);
    }

    @Override
    public ChangeInventoryRequestBuilder changeInventory() {
        return new DefaultChangeInventoryRequest.Builder(client);
    }

    @Override
    public DeleteInventoryRequestBuilder deleteInventory() {
        return new DefaultDeleteInventoryRequest.Builder(client);
    }

    @Override
    public GetRecentUploadsRequestBuilder getRecentUploads() {
        return new DefaultGetRecentUploadsRequest.Builder(client);
    }

    @Override
    public GetUploadRequestBuilder getUpload() {
        return new DefaultGetUploadRequest.Builder(client);
    }

    @Override
    public String toString() {
        return "DefaultInventoryUploadApi{" +
                "client=" + client +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultInventoryUploadApi that = (DefaultInventoryUploadApi) o;
        return Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client);
    }
}
