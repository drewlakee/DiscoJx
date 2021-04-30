package discojx;

import discojx.clients.DefaultLazyHttpClient;
import discojx.discogs.api.DefaultDiscogsApi;
import discojx.discogs.api.DiscogsApi;
import org.apache.http.Header;

import java.util.List;
import java.util.Objects;

public class DefaultApiDiscoJxFactory implements DiscoJxFactory {

    private List<Header> defaultHttpClientHeaders;

    public DefaultApiDiscoJxFactory setDefaultHttpClientHeaders(List<Header> defaultHttpClientHeaders) {
        this.defaultHttpClientHeaders = defaultHttpClientHeaders;
        return this;
    }

    public List<Header> getDefaultHttpClientHeaders() {
        return defaultHttpClientHeaders;
    }

    @Override
    public DiscogsApi create() {
        DefaultLazyHttpClient client = new DefaultLazyHttpClient().setCustomRequestHeaders(defaultHttpClientHeaders);
        return new DefaultDiscogsApi(client);
    }

    @Override
    public String toString() {
        return "DefaultApiDiscoJxFactory{" +
                "defaultHttpClientHeaders=" + defaultHttpClientHeaders +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultApiDiscoJxFactory that = (DefaultApiDiscoJxFactory) o;
        return Objects.equals(defaultHttpClientHeaders, that.defaultHttpClientHeaders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(defaultHttpClientHeaders);
    }
}
