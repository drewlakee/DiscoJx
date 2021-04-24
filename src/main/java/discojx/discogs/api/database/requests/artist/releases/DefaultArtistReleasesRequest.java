package discojx.discogs.api.database.requests.artist.releases;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.ArtistReleases;
import discojx.utils.json.JsonUtils;
import discojx.utils.requests.RequestParametersConstructor;
import discojx.utils.requests.StringBuilderSequentialRequestParametersConstructor;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultArtistReleasesRequest implements ArtistReleasesRequest {

    protected final AbstractHttpClient<HttpEntity> client;

    private final String queryUrl;

    public DefaultArtistReleasesRequest(Builder builder) {
        this.client = builder.client;
        this.queryUrl = builder.queryUrl;
    }

    public static class Builder implements ArtistReleasesRequestBuilder {

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
        public ArtistReleasesRequestBuilder artistId(long artistId) {
            this.artistId = artistId;
            return this;
        }

        @Override
        public ArtistReleasesRequestBuilder page(int page) {
            this.page = page;
            return this;
        }

        @Override
        public ArtistReleasesRequestBuilder perPage(int perPage) {
            this.perPage = perPage;
            return this;
        }

        @Override
        public ArtistReleasesRequestBuilder sort(String attribute) {
            this.sort = attribute;
            return this;
        }

        @Override
        public ArtistReleasesRequestBuilder sortOrder(String sortOrder) {
            this.sortOrder = sortOrder;
            return this;
        }

        @Override
        public ArtistReleasesRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .DATABASE_ARTIST_RELEASES
                    .getEndpointWith(constructPathParameters().toParametersString())
                    .replace("{artist_id}", String.valueOf(artistId));
            return new DefaultArtistReleasesRequest(this);
        }

        @Override
        public RequestParametersConstructor constructPathParameters() {
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
    public CompletableFuture<ArtistReleases> supplyFuture() {
        return CompletableFuture.supplyAsync(() -> {
            Optional<HttpEntity> execute = client.execute(new HttpGet(queryUrl));
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            ArtistReleases artistReleases;
            try {
                artistReleases = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(httpEntity.getContent(), ArtistReleases.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return artistReleases;
        });
    }

    @Override
    public String toString() {
        return "DefaultArtistReleasesRequest{" +
                "client=" + client +
                ", queryUrl='" + queryUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultArtistReleasesRequest that = (DefaultArtistReleasesRequest) o;
        return Objects.equals(client, that.client) && Objects.equals(queryUrl, that.queryUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, queryUrl);
    }
}
