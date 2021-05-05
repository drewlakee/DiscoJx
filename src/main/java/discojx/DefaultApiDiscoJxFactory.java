package discojx;

import discojx.clients.DefaultLazyHttpClient;
import discojx.discogs.api.DefaultDiscogsApi;
import discojx.discogs.api.DiscogsApi;
import org.apache.http.Header;

import java.util.List;
import java.util.Objects;

public class DefaultApiDiscoJxFactory implements DiscoJxFactory {

    protected List<Header> defaultCustomHttpClientHeaders;

    public DefaultApiDiscoJxFactory() {}

    public DefaultApiDiscoJxFactory(List<Header> defaultCustomHttpClientHeaders) {
        this.defaultCustomHttpClientHeaders = defaultCustomHttpClientHeaders;
    }

    @Override
    public DiscogsApi create() {
        DefaultLazyHttpClient client;

        if (defaultCustomHttpClientHeaders != null) {
            client = new DefaultLazyHttpClient(defaultCustomHttpClientHeaders);
        } else {
            client = new DefaultLazyHttpClient();
        }

        return new DefaultDiscogsApi(client);
    }

    @Override
    public String toString() {
        return "DefaultApiDiscoJxFactory{" +
                "defaultHttpClientHeaders=" + defaultCustomHttpClientHeaders +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultApiDiscoJxFactory that = (DefaultApiDiscoJxFactory) o;
        return Objects.equals(defaultCustomHttpClientHeaders, that.defaultCustomHttpClientHeaders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(defaultCustomHttpClientHeaders);
    }
}
