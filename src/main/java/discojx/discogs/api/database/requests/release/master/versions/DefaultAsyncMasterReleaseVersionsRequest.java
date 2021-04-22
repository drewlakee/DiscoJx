package discojx.discogs.api.database.requests.release.master.versions;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsEndpoints;
import discojx.discogs.objects.MasterReleaseVersions;
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

    private final String endpointParameters;

    public DefaultAsyncMasterReleaseVersionsRequest(Builder builder) {
        this.client = builder.client;
        this.masterId = builder.masterId;
        this.endpointParameters = builder.endpointParameters;
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

        private String endpointParameters;

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
            this.endpointParameters = constructParameters();
            return new DefaultAsyncMasterReleaseVersionsRequest(this);
        }

        @Override
        public String constructParameters() {
            List<String> parameters = new ArrayList<>();

            if (page > 0) parameters.add("page=" + page);
            if (perPage > 0) parameters.add("per_page=" + perPage);
            if (sort != null) parameters.add("sort=" + sort);
            if (sortOrder != null) parameters.add("sort_order=" + sortOrder);
            if (formats != null && formats.length > 0) Arrays.stream(formats).forEach(format -> parameters.add("format=" + format));
            if (labels != null && labels.length > 0) Arrays.stream(labels).forEach(label -> parameters.add("label=" + label));
            if (years != null && years.length > 0) Arrays.stream(years).forEach(years -> parameters.add("released=" + years));
            if (countries != null && countries.length > 0) Arrays.stream(countries).forEach(country -> parameters.add("county=" + country));

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
                    ", masterId=" + masterId +
                    ", formats=" + Arrays.toString(formats) +
                    ", labels=" + Arrays.toString(labels) +
                    ", years=" + Arrays.toString(years) +
                    ", countries=" + Arrays.toString(countries) +
                    ", endpointParameters='" + endpointParameters + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return page == builder.page && perPage == builder.perPage && masterId == builder.masterId && Objects.equals(client, builder.client) && Objects.equals(sort, builder.sort) && Objects.equals(sortOrder, builder.sortOrder) && Arrays.equals(formats, builder.formats) && Arrays.equals(labels, builder.labels) && Arrays.equals(years, builder.years) && Arrays.equals(countries, builder.countries) && Objects.equals(endpointParameters, builder.endpointParameters);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(client, page, perPage, sort, sortOrder, masterId, endpointParameters);
            result = 31 * result + Arrays.hashCode(formats);
            result = 31 * result + Arrays.hashCode(labels);
            result = 31 * result + Arrays.hashCode(years);
            result = 31 * result + Arrays.hashCode(countries);
            return result;
        }
    }

    @Override
    public CompletableFuture<MasterReleaseVersions> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            String endpoint = DiscogsEndpoints.DATABASE_MASTER_RELEASE_VERSIONS.getEndpoint().replace("{master_id}", String.valueOf(masterId)) + endpointParameters;
            Optional<HttpEntity> execute = client.execute(new HttpGet(endpoint));
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
                ", endpointParameters='" + endpointParameters + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultAsyncMasterReleaseVersionsRequest that = (DefaultAsyncMasterReleaseVersionsRequest) o;
        return masterId == that.masterId && Objects.equals(client, that.client) && Objects.equals(endpointParameters, that.endpointParameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, masterId, endpointParameters);
    }
}
