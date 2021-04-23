package discojx.discogs.api;

import discojx.discogs.api.database.DatabaseApi;
import discojx.discogs.api.user.UserApi;

public interface DiscogsApi {

    UserApi user();
    DatabaseApi database();
}
