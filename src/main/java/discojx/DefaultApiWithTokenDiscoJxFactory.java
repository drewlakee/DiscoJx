package discojx;

import discojx.clients.AbstractHttpClient;
import discojx.clients.DefaultLazyHttpClient;
import discojx.clients.authentication.PersonalAccessToken;
import discojx.discogs.api.DefaultDiscogsApi;
import discojx.discogs.api.DiscogsApi;
import org.apache.http.Header;

import java.util.List;
import java.util.Objects;

public class DefaultApiWithTokenDiscoJxFactory implements DiscoJxFactory {

    protected PersonalAccessToken token;

    protected List<Header> defaultCustomHttpClientHeaders;

    public DefaultApiWithTokenDiscoJxFactory(PersonalAccessToken token) {
        this.token = token;
    }

    public DefaultApiWithTokenDiscoJxFactory(PersonalAccessToken token, List<Header> defaultCustomHttpClientHeaders) {
        this.token = token;
        this.defaultCustomHttpClientHeaders = defaultCustomHttpClientHeaders;
    }

    @Override
    public DiscogsApi create() {
        AbstractHttpClient client;

        if (defaultCustomHttpClientHeaders != null) {
            client = new DefaultLazyHttpClient(token, defaultCustomHttpClientHeaders);
        } else {
            client = new DefaultLazyHttpClient(token);
        }

        return new DefaultDiscogsApi(client);
    }

    @Override
    public String toString() {
        return "DefaultApiWithTokenDiscoJxFactory{" +
                "defaultHttpClientHeaders=" + defaultCustomHttpClientHeaders +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultApiWithTokenDiscoJxFactory that = (DefaultApiWithTokenDiscoJxFactory) o;
        return Objects.equals(token, that.token) && Objects.equals(defaultCustomHttpClientHeaders, that.defaultCustomHttpClientHeaders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, defaultCustomHttpClientHeaders);
    }
}
