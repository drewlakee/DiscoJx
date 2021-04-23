package discojx;

import discojx.clients.authentication.PersonalAccessToken;
import discojx.discogs.api.DiscogsApi;
import org.apache.http.Header;

import java.util.List;

public interface DiscoJxFactory {

    DiscogsApi create();

    static DiscogsApi createDefaultApi() {
        return new DefaultApiDiscoJxFactory().create();
    }

    static DiscogsApi createDefaultApi(List<Header> defaultHeaders) {
        return new DefaultApiDiscoJxFactory().setDefaultHttpClientHeaders(defaultHeaders).create();
    }

    static DiscogsApi createDefaultApiWithToken(PersonalAccessToken token) {
        return new DefaultApiWithTokenDiscoJxFactory(token).create();
    }

    static DiscogsApi createDefaultApiWithToken(PersonalAccessToken token, List<Header> defaultHeaders) {
        return new DefaultApiWithTokenDiscoJxFactory(token).setDefaultHttpClientHeaders(defaultHeaders).create();
    }
}
