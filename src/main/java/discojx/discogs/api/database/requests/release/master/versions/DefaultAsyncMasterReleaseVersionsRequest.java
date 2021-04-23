package discojx.discogs.api.database.requests.release.master.versions;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsEndpoints;
import discojx.discogs.objects.MasterReleaseVersions;
import discojx.utils.requests.RequestParametersConstructor;
import discojx.utils.requests.StringBuilderSequentialRequestParametersConstructor;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultAsyncMasterReleaseVersionsRequest implements AsyncMasterReleaseVersionsRequest {

    protected final AbstractHttpClient<HttpEntity> client;

    protected static final ObjectMapper jsonMapper = new JsonMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private final long masterId;

    private final String queryUrl;

    public DefaultAsyncMasterReleaseVersionsRequest(Builder builder) {
        this.client = builder.client;
        this.masterId = builder.masterId;
        this.queryUrl = builder.queryUrl;
    }

    public static class Builder implements AsyncMasterReleaseVersionsRequestBuilder {

        private final AbstractHttpClient<HttpEntity> client;

        private int page;
        private int perPage;
        private String sort;
        private String sortOrder;
        private long masterId;
        private String[] formats;
        private String[] labels;
        private int[] years;
        private String[] countries;

        private String queryUrl;

        public Builder(AbstractHttpClient<HttpEntity> client) {
            this.client = client;
        }

        @Override
        public AsyncMasterReleaseVersionsRequestBuilder masterId(long masterId) {
            this.masterId = masterId;
            return this;
        }

        @Override
        public AsyncMasterReleaseVersionsRequestBuilder format(String... formats) {
            this.formats = formats;
            return this;
        }

        @Override
        public AsyncMasterReleaseVersionsRequestBuilder label(String... labels) {
            this.labels = labels;
            return this;
        }

        @Override
        public AsyncMasterReleaseVersionsRequestBuilder released(int... years) {
            this.years = years;
            return this;
        }

        @Override
        public AsyncMasterReleaseVersionsRequestBuilder country(String... countries) {
            this.countries = countries;
            return this;
        }

        @Override
        public AsyncMasterReleaseVersionsRequestBuilder page(int page) {
            this.page = page;
            return this;
        }

        @Override
        public AsyncMasterReleaseVersionsRequestBuilder perPage(int perPage) {
            this.perPage = perPage;
            return this;
        }

        @Override
        public AsyncMasterReleaseVersionsRequestBuilder sort(String attribute) {
            this.sort = attribute;
            return this;
        }

        @Override
        public AsyncMasterReleaseVersionsRequestBuilder sortOrder(String sortOrder) {
            this.sortOrder = sortOrder;
            return this;
        }

        @Override
        public AsyncMasterReleaseVersionsRequest build() {
            this.queryUrl = DiscogsEndpoints.DATABASE_MASTER_RELEASE_VERSIONS.getEndpointWith(constructParameters().toParametersString());
            return new DefaultAsyncMasterReleaseVersionsRequest(this);
        }

        @Override
        public RequestParametersConstructor constructParameters() {
            StringBuilderSequentialRequestParametersConstructor parameters =
                    new StringBuilderSequentialRequestParametersConstructor();

            if (page > 0) parameters.append("page", page);
            if (perPage > 0) parameters.append("per_page", perPage);
            if (sort != null) parameters.append("sort", sort);
            if (sortOrder != null) parameters.append("sort_order", sortOrder);
            if (formats != null && formats.length > 0) Arrays.stream(formats).forEach(format -> parameters.append("format", format));
            if (labels != null && labels.length > 0) Arrays.stream(labels).forEach(label -> parameters.append("label", label));
            if (years != null && years.length > 0) Arrays.stream(years).forEach(years -> parameters.append("released", years));
            if (countries != null && countries.length > 0) Arrays.stream(countries).forEach(country -> parameters.append("county", country));

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
                    ", masterId=" + masterId +
                    ", formats=" + Arrays.toString(formats) +
                    ", labels=" + Arrays.toString(labels) +
                    ", years=" + Arrays.toString(years) +
                    ", countries=" + Arrays.toString(countries) +
                    ", queryUrl='" + queryUrl + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return page == builder.page && perPage == builder.perPage && masterId == builder.masterId && Objects.equals(client, builder.client) && Objects.equals(sort, builder.sort) && Objects.equals(sortOrder, builder.sortOrder) && Arrays.equals(formats, builder.formats) && Arrays.equals(labels, builder.labels) && Arrays.equals(years, builder.years) && Arrays.equals(countries, builder.countries) && Objects.equals(queryUrl, builder.queryUrl);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(client, page, perPage, sort, sortOrder, masterId, queryUrl);
            result = 31 * result + Arrays.hashCode(formats);
            result = 31 * result + Arrays.hashCode(labels);
            result = 31 * result + Arrays.hashCode(years);
            result = 31 * result + Arrays.hashCode(countries);
            return result;
        }
    }

    @Override
    public CompletableFuture<MasterReleaseVersions> supplyFuture() {
        return CompletableFuture.supplyAsync(() -> {
            Optional<HttpEntity> execute = client.execute(new HttpGet(queryUrl.replace("{master_id}", String.valueOf(masterId))));
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            MasterReleaseVersions masterReleaseVersions;
            try {
                masterReleaseVersions = jsonMapper.readValue(httpEntity.getContent(), MasterReleaseVersions.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return masterReleaseVersions;
        });
    }

    @Override
    public String toString() {
        return "DefaultAsyncMasterReleaseVersionsRequest{" +
                "client=" + client +
                ", masterId=" + masterId +
                ", queryUrl='" + queryUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultAsyncMasterReleaseVersionsRequest that = (DefaultAsyncMasterReleaseVersionsRequest) o;
        return masterId == that.masterId && Objects.equals(client, that.client) && Objects.equals(queryUrl, that.queryUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, masterId, queryUrl);
    }
}
