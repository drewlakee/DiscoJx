package discojx.discogs.api.database.requests.artist;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.Artist;
import discojx.requests.AbstractRequest;
import discojx.requests.AbstractRequestBuilder;
import discojx.utils.json.JsonUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultArtistRequest extends AbstractRequest<HttpEntity>
        implements ArtistRequest {

    public DefaultArtistRequest(Builder builder) {
        super(builder);
    }

    public static class Builder extends AbstractRequestBuilder<HttpEntity>
            implements ArtistRequestBuilder {

        private long artistId;

        public Builder(AbstractHttpClient<HttpEntity> client) {
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
            Optional<HttpEntity> execute = client.execute(new HttpGet(queryUrl));
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            Artist artist;
            try {
                artist = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(httpEntity.getContent(), Artist.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return artist;
        });
    }
}
