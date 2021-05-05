package discojx.discogs.api.database.requests.artist;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.models.Artist;
import discojx.requests.AbstractRequest;
import discojx.requests.AbstractRequestBuilder;
import discojx.utils.json.JsonUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultArtistRequest extends AbstractRequest
        implements ArtistRequest {

    public DefaultArtistRequest(Builder builder) {
        super(builder);
    }

    public static class Builder extends AbstractRequestBuilder
            implements ArtistRequestBuilder {

        private long artistId;

        public Builder(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public ArtistRequestBuilder artistId(long artistId) {
            this.artistId = artistId;
            return this;
        }

        @Override
        public ArtistRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .DATABASE_ARTIST
                    .getEndpoint()
                    .replace("{artist_id}", String.valueOf(artistId));
            return new DefaultArtistRequest(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "client=" + client +
                    ", artistId=" + artistId +
                    ", queryUrl='" + queryUrl + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return artistId == builder.artistId && Objects.equals(client, builder.client) && Objects.equals(queryUrl, builder.queryUrl);
        }

        @Override
        public int hashCode() {
            return Objects.hash(client, artistId, queryUrl);
        }
    }

    @Override
    public CompletableFuture<Artist> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            HttpResponse response = client.execute(new HttpGet(queryUrl));

            Artist artist;
            try {
                artist = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(response.getEntity().getContent(), Artist.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return artist;
        });
    }
}
