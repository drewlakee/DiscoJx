package discojx.discogs.api.requests.impl;

import discojx.http.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.api.endpoints.inventory.export.requests.download.DownloadExportRequest;
import discojx.discogs.api.endpoints.inventory.export.requests.download.DownloadExportRequestBuilder;
import discojx.discogs.api.requests.AbstractRequest;
import discojx.discogs.api.requests.AbstractRequestBuilder;
import discojx.discogs.lib.FileResponseWrapper;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.nio.charset.Charset;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultDownloadExportRequest extends AbstractRequest
        implements DownloadExportRequest {

    public DefaultDownloadExportRequest(AbstractRequestBuilder builder) {
        super(builder);
    }

    public static class Builder extends AbstractRequestBuilder
            implements DownloadExportRequestBuilder {

        private long id;

        public Builder(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public DownloadExportRequestBuilder id(long id) {
            this.id = id;
            return this;
        }

        @Override
        public DownloadExportRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .INVENTORY_EXPORT_DOWNLOAD_EXPORT
                    .getEndpoint()
                    .replace("{id}", String.valueOf(id));
            return new DefaultDownloadExportRequest(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "id=" + id +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Builder builder = (Builder) o;
            return id == builder.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), id);
        }
    }

    @Override
    public CompletableFuture<FileResponseWrapper> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            HttpResponse response = client.execute(new HttpGet(queryUrl));
            Charset fileCharset = defineCharset(response);
            String filename = defineFilename(response);
            return new FileResponseWrapper(response, filename, fileCharset);
        });
    }

    protected Charset defineCharset(HttpResponse response) {
        Header contentType = response.getFirstHeader("Content-Type");
        String value = contentType.getValue();
        Pattern pattern = Pattern.compile("charset=?(.*)");
        Matcher matcher = pattern.matcher(value);
        Charset charset;
        if (matcher.find()) {
            charset = Charset.forName(matcher.group(1));
        } else {
            throw new CompletionException(response.toString(), new NullPointerException("Charset of received file is undefined."));
        }

        return charset;
    }

    protected String defineFilename(HttpResponse response) {
        Header contentDisposition = response.getFirstHeader("Content-Disposition");
        String value = contentDisposition.getValue();
        Pattern pattern = Pattern.compile("filename=?(.*)");
        Matcher matcher = pattern.matcher(value);
        String filename;
        if (matcher.find()) {
            filename = matcher.group(1);
        } else {
            throw new CompletionException(response.toString(), new NullPointerException("Filename of received file is undefined."));
        }

        return filename;
    }
}
