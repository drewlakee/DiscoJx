package discojx.discogs.api.database.requests.artist.releases;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsEndpoints;
import discojx.discogs.objects.ArtistReleases;
import discojx.utils.requests.RequestParametersConstructor;
import discojx.utils.requests.StringBuilderSequentialRequestParametersConstructor;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultAsyncArtistReleasesRequest implements AsyncArtistReleasesRequest {

    protected final AbstractHttpClient<HttpEntity> client;

    protected static final ObjectMapper jsonMapper = new JsonMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private final long artistId;

    private final String queryUrl;

    public DefaultAsyncArtistReleasesRequest(Builder builder) {
        this.client = builder.client;
        this.artistId = builder.artistId;
        this.queryUrl = builder.queryUrl;
    }

    public static class Builder implements AsyncArtistReleasesRequestBuilder {

        private final AbstractHttpClient<HttpEntity> client;

        private int page;
        private int perPage;
        private String sort;
        private String sortOrder;
        private long artistId;

        private String queryUrl;

        public Builder(AbstractHttpClient<HttpEntity> client) {
            this.client = client;
        }

        @Override
        public AsyncArtistReleasesRequestBuilder artistId(long artistId) {
            this.artistId = artistId;
            return this;
        }

        @Override
        public AsyncArtistReleasesRequestBuilder page(int page) {
            this.page = page;
            return this;
        }

        @Override
        public AsyncArtistReleasesRequestBuilder perPage(int perPage) {
            this.perPage = perPage;
            return this;
        }

        @Override
        public AsyncArtistReleasesRequestBuilder sort(String attribute) {
            this.sort = attribute;
            return this;
        }

        @Override
        public AsyncArtistReleasesRequestBuilder sortOrder(String sortOrder) {
            this.sortOrder = sortOrder;
            return this;
        }

        @Override
        public AsyncArtistReleasesRequest build() {
            this.queryUrl = DiscogsEndpoints.DATABASE_ARTIST_RELEASES.getEndpointWith(constructParameters().toParametersString());
            return new DefaultAsyncArtistReleasesRequest(this);
        }

        @Override
        public RequestParametersConstructor constructParameters() {
            StringBuilderSequentialRequestParametersConstructor parameters =
                    new StringBuilderSequentialRequestParametersConstructor();

            if (page > 0) parameters.append("page", page);
            if (perPage > 0) parameters.append("per_page", perPage);
            if (sort != null) parameters.append("sort", sort);
            if (sortOrder != null) parameters.append("sort_order", sortOrder);

            return parameters;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "client=" + client +
                    ", page=" + page +
                    ", perPage=" + perPage +
                    ", sort='" + sort + '\'' +
                    ", sortOrder='" + sortOrder + '\'' +
                    ", artistId=" + artistId +
                    ", queryUrl='" + queryUrl + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return page == builder.page && perPage == builder.perPage && artistId == builder.artistId && Objects.equals(client, builder.client) && Objects.equals(sort, builder.sort) && Objects.equals(sortOrder, builder.sortOrder) && Objects.equals(queryUrl, builder.queryUrl);
        }

        @Override
        public int hashCode() {
            return Objects.hash(client, page, perPage, sort, sortOrder, artistId, queryUrl);
        }
    }

    @Override
    public CompletableFuture<ArtistReleases> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            Optional<HttpEntity> execute = client.execute(new HttpGet(queryUrl.replace("{artist_id}", String.valueOf(artistId))));
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            ArtistReleases artistReleases;
            try {
                artistReleases = jsonMapper.readValue(httpEntity.getContent(), ArtistReleases.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return artistReleases;
        });
    }

    @Override
    public String toString() {
        return "DefaultAsyncArtistReleasesRequest{" +
                "client=" + client +
                ", artistId=" + artistId +
                ", queryUrl='" + queryUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultAsyncArtistReleasesRequest that = (DefaultAsyncArtistReleasesRequest) o;
        return artistId == that.artistId && Objects.equals(client, that.client) && Objects.equals(queryUrl, that.queryUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, artistId, queryUrl);
    }
}
