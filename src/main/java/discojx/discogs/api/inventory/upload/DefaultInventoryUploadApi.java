package discojx.discogs.api.inventory.upload;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.inventory.upload.requests.AddInventoryRequestBuilder;
import discojx.discogs.api.inventory.upload.requests.DefaultAddInventoryRequest;

import java.util.Objects;

public class DefaultInventoryUploadApi implements InventoryUploadApi {

    protected final AbstractHttpClient client;

    public DefaultInventoryUploadApi(AbstractHttpClient client) {
        this.client = client;
    }

    @Override
    public AddInventoryRequestBuilder add() {
        return new DefaultAddInventoryRequest.Builder(client);
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
