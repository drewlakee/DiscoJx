package discojx;

import discojx.clients.authentication.PersonalAccessToken;
import discojx.discogs.api.AsyncDiscogsApi;

public interface DiscoJx {

    AsyncDiscogsApi create();

    static AsyncDiscogsApi createDefaultApiWithToken(PersonalAccessToken token) {
        return new DefaultPersonalAccessTokenDiscoJx(token).create();
    }
}
