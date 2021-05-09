package discojx.discogs.lib;

import org.apache.http.HttpResponse;

import java.util.Objects;

public abstract class AbstractResponseWrapper {

    protected final HttpResponse httpResponse;

    public AbstractResponseWrapper(HttpResponse httpResponse) {
        this.httpResponse = httpResponse;
    }

    public HttpResponse response() {
        return httpResponse;
    }

    @Override
    public String toString() {
        return "ResponseWrapper{" +
                "httpResponse=" + httpResponse +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractResponseWrapper that = (AbstractResponseWrapper) o;
        return Objects.equals(httpResponse, that.httpResponse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(httpResponse);
    }
}
