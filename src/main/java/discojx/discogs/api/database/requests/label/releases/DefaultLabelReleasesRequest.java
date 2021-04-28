package discojx.discogs.api.database.requests.label.releases;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.LabelReleases;
import discojx.requests.AbstractPathParameterizedRequestBuilder;
import discojx.requests.AbstractRequest;
import discojx.utils.json.JsonUtils;
import discojx.utils.requests.RequestPathParametersConstructor;
import discojx.utils.requests.StringBuilderSequentialRequestPathParametersConstructor;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultLabelReleasesRequest extends AbstractRequest<HttpEntity>
        implements LabelReleasesRequest {

    public DefaultLabelReleasesRequest(Builder builder) {
        super(builder);
    }

    public static class Builder extends AbstractPathParameterizedRequestBuilder<HttpEntity, RequestPathParametersConstructor>
            implements LabelReleasesRequestBuilder {

        private int page;
        private int perPage;
        private String sort;
        private String sortOrder;
        private long labelId;

        public Builder(AbstractHttpClient<HttpEntity> client) {
            super(client);
        }

        @Override
        public LabelReleasesRequestBuilder labelId(long labelId) {
            this.labelId = labelId;
            return this;
        }

        @Override
        public LabelReleasesRequestBuilder page(int page) {
            this.page = page;
            return this;
        }

        @Override
        public LabelReleasesRequestBuilder perPage(int perPage) {
            this.perPage = perPage;
            return this;
        }

        @Override
        public LabelReleasesRequestBuilder sort(String attribute) {
            this.sort = attribute;
            return this;
        }

        @Override
        public LabelReleasesRequestBuilder sortOrder(String sortOrder) {
            this.sortOrder = sortOrder;
            return this;
        }

        @Override
        public LabelReleasesRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .DATABASE_LABEL_RELEASES
                    .getEndpointWith(constructPathParameters().toParametersString())
                    .replace("{label_id}", String.valueOf(labelId));
            return new DefaultLabelReleasesRequest(this);
        }

        @Override
        public RequestPathParametersConstructor constructPathParameters() {
            StringBuilderSequentialRequestPathParametersConstructor parameters =
                    new StringBuilderSequentialRequestPathParametersConstructor();

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
                    ", labelId=" + labelId +
                    ", queryUrl='" + queryUrl + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return page == builder.page && perPage == builder.perPage && labelId == builder.labelId && Objects.equals(client, builder.client) && Objects.equals(sort, builder.sort) && Objects.equals(sortOrder, builder.sortOrder) && Objects.equals(queryUrl, builder.queryUrl);
        }

        @Override
        public int hashCode() {
            return Objects.hash(client, page, perPage, sort, sortOrder, labelId, queryUrl);
        }
    }

    @Override
    public CompletableFuture<LabelReleases> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            Optional<HttpEntity> execute = client.execute(new HttpGet(queryUrl));
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            LabelReleases labelReleases;
            try {
                labelReleases = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(httpEntity.getContent(), LabelReleases.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return labelReleases;
        });
    }
}
