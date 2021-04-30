package discojx.discogs.api.inventory.upload.requests;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.requests.AbstractRequest;
import discojx.requests.AbstractRequestBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.nio.file.Path;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class DefaultAddInventoryRequest extends AbstractRequest
        implements AddInventoryRequest {

    private final Path pathToCsvFile;

    public DefaultAddInventoryRequest(Builder builder) {
        super(builder);
        this.pathToCsvFile = builder.pathToCsvFile;
    }

    public static class Builder extends AbstractRequestBuilder
            implements AddInventoryRequestBuilder {

        private Path pathToCsvFile;

        public Builder(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public AddInventoryRequestBuilder csvFile(Path pathToCsvFile) {
            this.pathToCsvFile = pathToCsvFile;
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
        return "DefaultAddInventoryRequest{" +
                "pathToCsvFile=" + pathToCsvFile +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DefaultAddInventoryRequest that = (DefaultAddInventoryRequest) o;
        return Objects.equals(pathToCsvFile, that.pathToCsvFile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pathToCsvFile);
    }
}
