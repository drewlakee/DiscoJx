package discojx;

import discojx.clients.authentication.PersonalAccessToken;
import discojx.discogs.api.AsyncDiscogsApi;

public interface DiscoJxFactory {

    AsyncDiscogsApi create();

    static AsyncDiscogsApi createDefaultApiWithToken(PersonalAccessToken token) {
        return new DefaultApiWithTokenDiscoJxFactory(token).create();
    }
}
