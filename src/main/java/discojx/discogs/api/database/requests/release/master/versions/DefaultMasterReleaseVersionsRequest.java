package discojx.discogs.api.database.requests.release.master.versions;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.MasterReleaseVersions;
import discojx.requests.AbstractPathParameterizedRequestBuilder;
import discojx.requests.AbstractRequest;
import discojx.utils.json.JsonUtils;
import discojx.utils.requests.RequestPathParametersConstructor;
import discojx.utils.requests.StringBuilderSequentialRequestPathParametersConstructor;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultMasterReleaseVersionsRequest extends AbstractRequest
        implements MasterReleaseVersionsRequest {

    public DefaultMasterReleaseVersionsRequest(Builder builder) {
        super(builder);
    }

    public static class Builder extends AbstractPathParameterizedRequestBuilder<RequestPathParametersConstructor>
            implements MasterReleaseVersionsRequestBuilder {

        private int page;
        private int perPage;
        private String sort;
        private String sortOrder;
        private long masterId;
        private String[] formats;
        private String[] labels;
        private int[] years;
        private String[] countries;

        public Builder(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public MasterReleaseVersionsRequestBuilder masterId(long masterId) {
            this.masterId = masterId;
            return this;
        }

        @Override
        public MasterReleaseVersionsRequestBuilder format(String... formats) {
            this.formats = formats;
            return this;
        }

        @Override
        public MasterReleaseVersionsRequestBuilder label(String... labels) {
            this.labels = labels;
            return this;
        }

        @Override
        public MasterReleaseVersionsRequestBuilder released(int... years) {
            this.years = years;
            return this;
        }

        @Override
        public MasterReleaseVersionsRequestBuilder country(String... countries) {
            this.countries = countries;
            return this;
        }

        @Override
        public MasterReleaseVersionsRequestBuilder page(int page) {
            this.page = page;
            return this;
        }

        @Override
        public MasterReleaseVersionsRequestBuilder perPage(int perPage) {
            this.perPage = perPage;
            return this;
        }

        @Override
        public MasterReleaseVersionsRequestBuilder sort(String attribute) {
            this.sort = attribute;
            return this;
        }

        @Override
        public MasterReleaseVersionsRequestBuilder sortOrder(String sortOrder) {
            this.sortOrder = sortOrder;
            return this;
        }

        @Override
        public MasterReleaseVersionsRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .DATABASE_MASTER_RELEASE_VERSIONS
                    .getEndpointWith(constructPathParameters().toParametersString())
                    .replace("{master_id}", String.valueOf(masterId));
            return new DefaultMasterReleaseVersionsRequest(this);
        }

        @Override
        public RequestPathParametersConstructor constructPathParameters() {
            StringBuilderSequentialRequestPathParametersConstructor parameters =
                    new StringBuilderSequentialRequestPathParametersConstructor();

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
    public CompletableFuture<MasterReleaseVersions> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            HttpResponse response = client.execute(new HttpGet(queryUrl));

            MasterReleaseVersions masterReleaseVersions;
            try {
                masterReleaseVersions = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(response.getEntity().getContent(), MasterReleaseVersions.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return masterReleaseVersions;
        });
    }
}
