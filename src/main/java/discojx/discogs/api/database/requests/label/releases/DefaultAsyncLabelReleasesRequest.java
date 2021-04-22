package discojx.discogs.api.database.requests.label.releases;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsEndpoints;
import discojx.discogs.objects.LabelReleases;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultAsyncLabelReleasesRequest implements AsyncLabelReleasesRequest {

    protected final AbstractHttpClient<HttpEntity> client;

    protected static final ObjectMapper jsonMapper = new JsonMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private final long labelId;

    private final String endpointParameters;

    public DefaultAsyncLabelReleasesRequest(Builder builder) {
        this.client = builder.client;
        this.labelId = builder.labelId;
        this.endpointParameters = builder.endpointParameters;
    }

    public static class Builder implements AsyncLabelReleasesRequestBuilder {

        private final AbstractHttpClient<HttpEntity> client;

        private int page;
        private int perPage;
        private String sort;
        private String sortOrder;
        private long labelId;

        private String endpointParameters;

        public Builder(AbstractHttpClient<HttpEntity> client) {
            this.client = client;
        }

        @Override
        public AsyncLabelReleasesRequestBuilder labelId(long labelId) {
            this.labelId = labelId;
            return this;
        }

        @Override
        public AsyncLabelReleasesRequestBuilder page(int page) {
            this.page = page;
            return this;
        }

        @Override
        public AsyncLabelReleasesRequestBuilder perPage(int perPage) {
            this.perPage = perPage;
            return this;
        }

        @Override
        public AsyncLabelReleasesRequestBuilder sort(String attribute) {
            this.sort = attribute;
            return this;
        }

        @Override
        public AsyncLabelReleasesRequestBuilder sortOrder(String sortOrder) {
            this.sortOrder = sortOrder;
            return this;
        }

        @Override
        public AsyncLabelReleasesRequest build() {
            this.endpointParameters = constructParameters();
            return new DefaultAsyncLabelReleasesRequest(this);
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

    }

    @Override
    public CompletableFuture<LabelReleases> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            Optional<HttpEntity> execute = client.execute(new HttpGet(DiscogsEndpoints.DATABASE_LABEL_RELEASES.getEndpoint().replace("{label_id}", String.valueOf(labelId)) + endpointParameters));
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            LabelReleases labelReleases;
            try {
                labelReleases = jsonMapper.readValue(httpEntity.getContent(), LabelReleases.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return labelReleases;
        });
    }

    @Override
    public String toString() {
        return "DefaultAsyncLabelReleasesRequest{" +
                "client=" + client +
                ", labelId=" + labelId +
                ", endpointParameters='" + endpointParameters + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultAsyncLabelReleasesRequest that = (DefaultAsyncLabelReleasesRequest) o;
        return labelId == that.labelId && Objects.equals(client, that.client) && Objects.equals(endpointParameters, that.endpointParameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, labelId, endpointParameters);
    }
}
