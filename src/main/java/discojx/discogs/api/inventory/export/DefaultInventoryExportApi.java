package discojx.discogs.api.inventory.export;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.inventory.export.requests.download.DefaultDownloadExportRequest;
import discojx.discogs.api.inventory.export.requests.download.DownloadExportRequestBuilder;
import discojx.discogs.api.inventory.export.requests.get.DefaultGetExportRequest;
import discojx.discogs.api.inventory.export.requests.get.GetExportRequestBuilder;
import discojx.discogs.api.inventory.export.requests.recent.DefaultGetRecentExportsRequest;
import discojx.discogs.api.inventory.export.requests.recent.GetRecentExportsRequestBuilder;
import discojx.discogs.api.inventory.export.requests.your.DefaultExportYourInventoryRequest;
import discojx.discogs.api.inventory.export.requests.your.ExportYourInventoryRequest;

import java.util.Objects;

public class DefaultInventoryExportApi implements InventoryExportApi {

    protected final AbstractHttpClient client;

    public DefaultInventoryExportApi(AbstractHttpClient client) {
        this.client = client;
    }

    @Override
    public ExportYourInventoryRequest yourInventory() {
        return new DefaultExportYourInventoryRequest(client);
    }

    @Override
    public GetRecentExportsRequestBuilder getRecentExports() {
        return new DefaultGetRecentExportsRequest.Builder(client);
    }

    @Override
    public GetExportRequestBuilder getExport() {
        return new DefaultGetExportRequest.Builder(client);
    }

    @Override
    public DownloadExportRequestBuilder downloadExport() {
        return new DefaultDownloadExportRequest.Builder(client);
    }

    @Override
    public String toString() {
        return "DefaultInventoryExportApi{" +
                "client=" + client +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultInventoryExportApi that = (DefaultInventoryExportApi) o;
        return Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client);
    }
}
