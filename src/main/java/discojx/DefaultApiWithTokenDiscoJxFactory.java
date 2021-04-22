package discojx;

import discojx.clients.DefaultLazyHttpClient;
import discojx.clients.authentication.PersonalAccessToken;
import discojx.discogs.api.AsyncDiscogsApi;
import discojx.discogs.api.DefaultAsyncDiscogsApi;
import org.apache.http.Header;

import java.util.List;
import java.util.Objects;

public class DefaultApiWithTokenDiscoJxFactory implements DiscoJxFactory {

    private final PersonalAccessToken token;

    private List<Header> defaultHttpClientHeaders;

    public DefaultApiWithTokenDiscoJxFactory(PersonalAccessToken token) {
        this.token = token;
    }

    public DefaultApiWithTokenDiscoJxFactory setDefaultHttpClientHeaders(List<Header> defaultHeaders) {
        this.defaultHttpClientHeaders = defaultHeaders;
        return this;
    }

    public List<Header> getDefaultHttpClientHeaders() {
        return defaultHttpClientHeaders;
    }

    @Override
    public AsyncDiscogsApi create() {
        DefaultLazyHttpClient client = new DefaultLazyHttpClient(token).setHeaders(defaultHttpClientHeaders);
        return new DefaultAsyncDiscogsApi(client);
    }

    @Override
    public String toString() {
        return "DefaultApiWithTokenDiscoJxFactory{" +
                "token=" + token +
                ", userAgent='" + defaultHttpClientHeaders + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultApiWithTokenDiscoJxFactory that = (DefaultApiWithTokenDiscoJxFactory) o;
        return Objects.equals(token, that.token) && Objects.equals(defaultHttpClientHeaders, that.defaultHttpClientHeaders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, defaultHttpClientHeaders);
    }
}