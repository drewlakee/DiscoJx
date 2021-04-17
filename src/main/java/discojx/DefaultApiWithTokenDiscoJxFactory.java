package discojx;

import discojx.clients.PersonalAccessTokenLazyHttpClient;
import discojx.clients.authentication.PersonalAccessToken;
import discojx.discogs.api.AsyncDiscogsApi;
import discojx.discogs.api.DefaultAsyncDiscogsApi;

import java.util.Objects;

public class DefaultApiWithTokenDiscoJxFactory implements DiscoJxFactory {

    private final PersonalAccessToken token;

    public DefaultApiWithTokenDiscoJxFactory(PersonalAccessToken token) {
        this.token = token;
    }

    @Override
    public AsyncDiscogsApi create() {
        return new DefaultAsyncDiscogsApi(new PersonalAccessTokenLazyHttpClient(token));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultApiWithTokenDiscoJxFactory that = (DefaultApiWithTokenDiscoJxFactory) o;
        return Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token);
    }
}
