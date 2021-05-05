package discojx.discogs.api.requests.impl;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.api.endpoints.inventory.export.requests.your.ExportYourInventoryRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class DefaultExportYourInventoryRequest implements ExportYourInventoryRequest {

    protected final AbstractHttpClient client;

    public DefaultExportYourInventoryRequest(AbstractHttpClient client) {
        this.client = client;
    }

    @Override
    public CompletableFuture<HttpResponse> executeAsync() {
        return CompletableFuture.supplyAsync(() -> client.execute(new HttpPost(DiscogsApiEndpoints.INVENTORY_EXPORT_GET_YOUR_INVENTORY.getEndpoint())));
    }

    @Override
    public String toString() {
        return "DefaultExportYourInventoryRequest{" +
                "client=" + client +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultExportYourInventoryRequest that = (DefaultExportYourInventoryRequest) o;
        return Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client);
    }
}
