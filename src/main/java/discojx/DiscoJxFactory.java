package discojx;

import discojx.clients.authentication.PersonalAccessToken;
import discojx.discogs.api.AsyncDiscogsApi;
import org.apache.http.Header;

import java.util.List;

public interface DiscoJxFactory {

    AsyncDiscogsApi create();

    static AsyncDiscogsApi createDefaultApi() {
        return new DefaultApiDiscoJxFactory().create();
    }

    static AsyncDiscogsApi createDefaultApi(List<Header> defaultHeaders) {
        return new DefaultApiDiscoJxFactory().setDefaultHttpClientHeaders(defaultHeaders).create();
    }

    static AsyncDiscogsApi createDefaultApiWithToken(PersonalAccessToken token) {
        return new DefaultApiWithTokenDiscoJxFactory(token).create();
    }

    static AsyncDiscogsApi createDefaultApiWithToken(PersonalAccessToken token, List<Header> defaultHeaders) {
        return new DefaultApiWithTokenDiscoJxFactory(token).setDefaultHttpClientHeaders(defaultHeaders).create();
    }
}
