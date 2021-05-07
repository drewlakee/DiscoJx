package discojx.discogs.api.requests.impl;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.api.endpoints.inventory.upload.requests.add.AddInventoryRequest;
import discojx.discogs.api.endpoints.inventory.upload.requests.add.AddInventoryRequestBuilder;
import discojx.discogs.api.requests.AbstractRequest;
import discojx.discogs.api.requests.AbstractRequestBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.io.InputStream;
import java.nio.file.Path;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class DefaultAddInventoryRequest extends AbstractRequest
        implements AddInventoryRequest {

    protected final Path pathToCsvFile;
    protected final InputStream csvFileInputStream;

    public DefaultAddInventoryRequest(Builder builder) {
        super(builder);
        this.pathToCsvFile = builder.pathToCsvFile;
        this.csvFileInputStream = builder.csvFileInputStream;
    }

    public static class Builder extends AbstractRequestBuilder
            implements AddInventoryRequestBuilder {

        private Path pathToCsvFile;
        private InputStream csvFileInputStream;

        public Builder(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public AddInventoryRequestBuilder csvFile(Path pathToCsvFile) {
            this.csvFileInputStream = null;
            this.pathToCsvFile = pathToCsvFile;
            return this;
        }

        @Override
        public AddInventoryRequestBuilder csvFile(InputStream csvFileInputStream) {
            this.pathToCsvFile = null;
            this.csvFileInputStream = csvFileInputStream;
            return this;
        }

        @Override
        public AddInventoryRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .INVENTORY_UPLOAD_ADD
                    .getEndpoint();
            return new DefaultAddInventoryRequest(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "pathToCsvFile=" + pathToCsvFile +
                    ", csvFileInputStream=" + csvFileInputStream +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Builder builder = (Builder) o;
            return Objects.equals(pathToCsvFile, builder.pathToCsvFile) && Objects.equals(csvFileInputStream, builder.csvFileInputStream);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), pathToCsvFile, csvFileInputStream);
        }
    }

    @Override
    public CompletableFuture<HttpResponse> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            HttpPost request = new HttpPost(queryUrl);
            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();

            if (pathToCsvFile != null) {
                multipartEntityBuilder.addBinaryBody("upload", pathToCsvFile.toFile());
            } else {
                multipartEntityBuilder.addBinaryBody("upload", csvFileInputStream);
            }

            HttpEntity fileEntity = multipartEntityBuilder.build();
            request.setEntity(fileEntity);
            return client.execute(request);
        });
    }

    @Override
    public String toString() {
        return "DefaultAddInventoryRequest{" +
                "pathToCsvFile=" + pathToCsvFile +
                ", csvFileInputStream=" + csvFileInputStream +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DefaultAddInventoryRequest that = (DefaultAddInventoryRequest) o;
        return Objects.equals(pathToCsvFile, that.pathToCsvFile) && Objects.equals(csvFileInputStream, that.csvFileInputStream);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pathToCsvFile, csvFileInputStream);
    }
}
