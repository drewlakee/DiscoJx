package discojx;

import discojx.clients.PersonalAccessTokenLazyHttpClient;
import discojx.discogs.api.AsyncDiscogsApi;
import discojx.discogs.api.DefaultAsyncDiscogsApi;

public class DiscoJx {

    public static AsyncDiscogsApi createDefaultApiWith(String personalAccessToken) {
        return new DefaultAsyncDiscogsApi(new PersonalAccessTokenLazyHttpClient(personalAccessToken));
    }
}
