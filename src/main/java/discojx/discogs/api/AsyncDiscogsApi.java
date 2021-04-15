package discojx.discogs.api;

import discojx.discogs.api.user.AsyncUserApi;

public interface AsyncDiscogsApi {

    AsyncUserApi user();
}
