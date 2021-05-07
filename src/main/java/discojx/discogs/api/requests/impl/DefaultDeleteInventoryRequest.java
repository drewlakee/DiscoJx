package discojx.discogs.api.requests.impl;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.api.endpoints.inventory.upload.requests.delete.DeleteInventoryRequest;
import discojx.discogs.api.endpoints.inventory.upload.requests.delete.DeleteInventoryRequestBuilder;
import discojx.discogs.api.requests.AbstractRequest;
import discojx.discogs.api.requests.AbstractRequestBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.nio.file.Path;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class DefaultDeleteInventoryRequest extends AbstractRequest
        implements DeleteInventoryRequest {

    protected final Path pathToCsvFile;

    public DefaultDeleteInventoryRequest(Builder builder) {
        super(builder);
        this.pathToCsvFile = builder.pathToCsvFile;
    }

    public static class Builder extends AbstractRequestBuilder
            implements DeleteInventoryRequestBuilder {

        private Path pathToCsvFile;

        public Builder(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public DeleteInventoryRequestBuilder csvFile(Path pathToCsvFile) {
            this.pathToCsvFile = pathToCsvFile;
            return this;
        }

        @Override
        public DeleteInventoryRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .INVENTORY_UPLOAD_DELETE
                    .getEndpoint();
            return new DefaultDeleteInventoryRequest(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "pathToCsvFile=" + pathToCsvFile +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Builder builder = (Builder) o;
            return Objects.equals(pathToCsvFile, builder.pathToCsvFile);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), pathToCsvFile);
        }
    }

    @Override
    public CompletableFuture<HttpResponse> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            HttpPost request = new HttpPost(queryUrl);
            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
            multipartEntityBuilder.addBinaryBody("upload", pathToCsvFile.toFile());
            HttpEntity fileEntity = multipartEntityBuilder.build();
            request.setEntity(fileEntity);
            return client.execute(request);
        });
    }

    @Override
    public String toString() {
        return "DefaultDeleteInventoryRequest{" +
                "pathToCsvFile=" + pathToCsvFile +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DefaultDeleteInventoryRequest that = (DefaultDeleteInventoryRequest) o;
        return Objects.equals(pathToCsvFile, that.pathToCsvFile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pathToCsvFile);
    }
}
