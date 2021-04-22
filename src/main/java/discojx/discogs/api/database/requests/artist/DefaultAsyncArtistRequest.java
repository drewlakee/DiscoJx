package discojx.discogs.api.database.requests.artist;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsEndpoints;
import discojx.discogs.objects.Artist;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultAsyncArtistRequest implements AsyncArtistRequest {

    protected final AbstractHttpClient<HttpEntity> client;

    protected static final ObjectMapper jsonMapper = new JsonMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private final long artistId;

    public DefaultAsyncArtistRequest(Builder builder) {
        this.client = builder.client;
        this.artistId = builder.artistId;
    }

    public static class Builder implements AsyncArtistRequestBuilder {

        private final AbstractHttpClient<HttpEntity> client;

        private long artistId;

        public Builder(AbstractHttpClient<HttpEntity> client) {
            this.client = client;
        }

        @Override
        public AsyncArtistRequestBuilder artistId(long artistId) {
            this.artistId = artistId;
            return this;
        }

        @Override
        public AsyncArtistRequest build() {
            return new DefaultAsyncArtistRequest(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "client=" + client +
                    ", artistId=" + artistId +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return artistId == builder.artistId && Objects.equals(client, builder.client);
        }

        @Override
        public int hashCode() {
            return Objects.hash(client, artistId);
        }
    }

    @Override
    public CompletableFuture<Artist> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            Optional<HttpEntity> execute = client.execute(new HttpGet(DiscogsEndpoints.DATABASE_ARTIST.getEndpoint().replace("{artist_id}", String.valueOf(artistId))));
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            Artist artist;
            try {
                artist = jsonMapper.readValue(httpEntity.getContent(), Artist.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return artist;
        });
    }
}
