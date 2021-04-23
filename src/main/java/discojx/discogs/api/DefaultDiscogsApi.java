package discojx.discogs.api;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.database.DatabaseApi;
import discojx.discogs.api.database.DefaultDatabaseApi;
import discojx.discogs.api.user.UserApi;
import discojx.discogs.api.user.DefaultUserApi;
import org.apache.http.HttpEntity;

import java.util.Objects;

public class DefaultDiscogsApi implements DiscogsApi {

    private final DefaultUserApi userApi;
    private final DefaultDatabaseApi databaseApi;

    public DefaultDiscogsApi(AbstractHttpClient<HttpEntity> client) {
        this.userApi = new DefaultUserApi(client);
        this.databaseApi = new DefaultDatabaseApi(client);
    }

    @Override
    public UserApi user() {
        return userApi;
    }

    @Override
    public DatabaseApi database() {
        return databaseApi;
    }

    @Override
    public String toString() {
        return "DefaultDiscogsApi{" +
                "userApi=" + userApi +
                ", databaseApi=" + databaseApi +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultDiscogsApi api = (DefaultDiscogsApi) o;
        return Objects.equals(userApi, api.userApi) && Objects.equals(databaseApi, api.databaseApi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userApi, databaseApi);
    }
}
