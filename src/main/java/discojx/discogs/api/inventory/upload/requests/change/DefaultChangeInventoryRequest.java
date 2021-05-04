package discojx.discogs.api.inventory.upload.requests.change;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.requests.AbstractRequest;
import discojx.requests.AbstractRequestBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.io.InputStream;
import java.nio.file.Path;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class DefaultChangeInventoryRequest extends AbstractRequest
        implements ChangeInventoryRequest {

    protected final Path pathToCsvFile;
    protected final InputStream csvFileInputStream;

    public DefaultChangeInventoryRequest(Builder builder) {
        super(builder);
        this.pathToCsvFile = builder.pathToCsvFile;
        this.csvFileInputStream = builder.csvFileInputStream;
    }

    public static class Builder extends AbstractRequestBuilder
            implements ChangeInventoryRequestBuilder {

        private Path pathToCsvFile;
        private InputStream csvFileInputStream;

        public Builder(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public ChangeInventoryRequestBuilder csvFile(Path pathToCsvFile) {
            this.csvFileInputStream = null;
            this.pathToCsvFile = pathToCsvFile;
            return this;
        }

        @Override
        public ChangeInventoryRequestBuilder csvFile(InputStream csvFileInputStream) {
            this.pathToCsvFile = null;
            this.csvFileInputStream = csvFileInputStream;
            return this;
        }

        @Override
        public ChangeInventoryRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .INVENTORY_UPLOAD_CHANGE
                    .getEndpoint();
            return new DefaultChangeInventoryRequest(this);
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
        return "DefaultChangeInventoryRequest{" +
                "pathToCsvFile=" + pathToCsvFile +
                ", csvFileInputStream=" + csvFileInputStream +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DefaultChangeInventoryRequest that = (DefaultChangeInventoryRequest) o;
        return Objects.equals(pathToCsvFile, that.pathToCsvFile) && Objects.equals(csvFileInputStream, that.csvFileInputStream);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pathToCsvFile, csvFileInputStream);
    }
}
