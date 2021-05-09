package discojx.discogs.lib;

import org.apache.http.HttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Objects;

public class FileResponseWrapper extends AbstractResponseWrapper {

    protected final String receivedFilename;
    protected final Charset charset;

    public FileResponseWrapper(HttpResponse httpResponse, String receivedFilename, Charset charset) {
        super(httpResponse);
        this.receivedFilename = receivedFilename;
        this.charset = charset;
    }

    public Charset charset() {
        return charset;
    }

    public String filename() {
        return receivedFilename;
    }

    public BufferedReader toBufferedReader() throws IOException {
        return new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
    }

    @Override
    public String toString() {
        return "FileResponseWrapper{" +
                "receivedFilename='" + receivedFilename + '\'' +
                ", charset=" + charset +
                ", httpResponse=" + httpResponse +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FileResponseWrapper that = (FileResponseWrapper) o;
        return Objects.equals(receivedFilename, that.receivedFilename) && Objects.equals(charset, that.charset);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), receivedFilename, charset);
    }
}
