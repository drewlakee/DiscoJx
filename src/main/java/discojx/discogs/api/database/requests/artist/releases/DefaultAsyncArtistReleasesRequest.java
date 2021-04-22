package discojx.discogs.api.database.requests.artist.releases;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsEndpoints;
import discojx.discogs.objects.ArtistReleases;
import discojx.discogs.objects.Release;
import discojx.requests.ParameterizedRequest;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultAsyncArtistReleasesRequest implements AsyncArtistReleasesRequest {

    protected final AbstractHttpClient<HttpEntity> client;

    protected static final ObjectMapper jsonMapper = new JsonMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private final long artistId;

    private final String endpointParameters;

    public DefaultAsyncArtistReleasesRequest(Builder builder) {
        this.client = builder.client;
        this.artistId = builder.artistId;
        this.endpointParameters = builder.endpointParameters;
    }

    public static class Builder implements AsyncArtistReleasesRequestBuilder, ParameterizedRequest<String> {

        private final AbstractHttpClient<HttpEntity> client;

        private int page;
        private int perPage;
        private String sort;
        private String sortOrder;
        private long artistId;

        private String endpointParameters;

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
            this.endpointParameters = constructParameters();
            return new DefaultAsyncArtistReleasesRequest(this);
        }

        @Override
        public String constructParameters() {
            List<String> parameters = new ArrayList<>();

            if (page > 0) parameters.add("page=" + page);
            if (perPage > 0) parameters.add("per_page=" + perPage);
            if (sort != null) parameters.add("sort=" + sort);
            if (sortOrder != null) parameters.add("sort_order=" + sortOrder);

            if (parameters.isEmpty()) {
                return "";
            } else {
                return "?" + String.join("&", parameters);
            }
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
                    ", endpointParameters='" + endpointParameters + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return page == builder.page && perPage == builder.perPage && artistId == builder.artistId && Objects.equals(client, builder.client) && Objects.equals(sort, builder.sort) && Objects.equals(sortOrder, builder.sortOrder) && Objects.equals(endpointParameters, builder.endpointParameters);
        }

        @Override
        public int hashCode() {
            return Objects.hash(client, page, perPage, sort, sortOrder, artistId, endpointParameters);
        }
    }

    @Override
    public CompletableFuture<ArtistReleases> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            Optional<HttpEntity> execute = client.execute(new HttpGet(DiscogsEndpoints.DATABASER_ARTIST_RELEASES.getEndpoint().replace("{artist_id}", String.valueOf(artistId)) + endpointParameters));
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
                ", endpointParameters='" + endpointParameters + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultAsyncArtistReleasesRequest that = (DefaultAsyncArtistReleasesRequest) o;
        return artistId == that.artistId && Objects.equals(client, that.client) && Objects.equals(endpointParameters, that.endpointParameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, artistId, endpointParameters);
    }
}
