package discojx.utils.files;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Objects;

public class FileResponseWrapper {

    protected final HttpResponse httpResponse;
    protected final String receivedFilename;
    protected final Charset charset;

    public FileResponseWrapper(HttpResponse httpResponse, String receivedFilename, Charset charset) {
        this.httpResponse = httpResponse;
        this.receivedFilename = receivedFilename;
        this.charset = charset;
    }

    public HttpResponse getHttpResponse() {
        return httpResponse;
    }

    public String getReceivedFilename() {
        return receivedFilename;
    }

    public Charset getCharset() {
        return charset;
    }

    public BufferedReader toBufferedReader() throws IOException {
        HttpEntity entity = httpResponse.getEntity();
        InputStream content = entity.getContent();
        return new BufferedReader(new InputStreamReader(content));
    }

    @Override
    public String toString() {
        return "FileResponseWrapper{" +
                "httpResponse=" + httpResponse +
                ", receivedFilename='" + receivedFilename + '\'' +
                ", charset=" + charset +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileResponseWrapper wrapper = (FileResponseWrapper) o;
        return Objects.equals(httpResponse, wrapper.httpResponse) && Objects.equals(receivedFilename, wrapper.receivedFilename) && Objects.equals(charset, wrapper.charset);
    }

    @Override
    public int hashCode() {
        return Objects.hash(httpResponse, receivedFilename, charset);
    }
}
