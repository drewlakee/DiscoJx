package discojx;

import discojx.discogs.api.DiscogsApi;

public interface DiscoJxFactory {

    DiscogsApi create();
}
