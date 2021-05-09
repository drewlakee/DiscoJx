package discojx.discogs.api.requests.impl;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.http.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.api.endpoints.inventory.upload.requests.recent.GetRecentUploadsRequest;
import discojx.discogs.api.endpoints.inventory.upload.requests.recent.GetRecentUploadsRequestBuilder;
import discojx.discogs.api.requests.AbstractPathParameterizedRequestBuilder;
import discojx.discogs.api.requests.AbstractRequest;
import discojx.discogs.api.requests.AbstractRequestBuilder;
import discojx.discogs.lib.EntityResponseWrapper;
import discojx.utils.json.JsonUtils;
import discojx.utils.requests.RequestPathParametersConstructor;
import discojx.utils.requests.StringBuilderSequentialRequestPathParametersConstructor;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultGetRecentUploadsRequest extends AbstractRequest
        implements GetRecentUploadsRequest {

    public DefaultGetRecentUploadsRequest(AbstractRequestBuilder builder) {
        super(builder);
    }

    public static class Builder extends AbstractPathParameterizedRequestBuilder<RequestPathParametersConstructor>
            implements GetRecentUploadsRequestBuilder {

        private int page;
        private int perPage;

        public Builder(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public GetRecentUploadsRequestBuilder page(int page) {
            this.page = page;
            return this;
        }

        @Override
        public GetRecentUploadsRequestBuilder perPage(int perPage) {
            this.perPage = perPage;
            return this;
        }

        @Override
        public GetRecentUploadsRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .INVENTORY_UPLOAD_GET_RECENT_UPLOADS
                    .getEndpointWith(constructPathParameters().toParametersString());
            return new DefaultGetRecentUploadsRequest(this);
        }

        @Override
        public RequestPathParametersConstructor constructPathParameters() {
            StringBuilderSequentialRequestPathParametersConstructor parameters =
                    new StringBuilderSequentialRequestPathParametersConstructor();

            if (page > 0) parameters.append("page", page);
            if (perPage > 0) parameters.append("per_page", perPage);

            return parameters;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "page=" + page +
                    ", perPage=" + perPage +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Builder builder = (Builder) o;
            return page == builder.page && perPage == builder.perPage;
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), page, perPage);
        }
    }

    @Override
    public CompletableFuture<EntityResponseWrapper<JsonNode>> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            HttpResponse response = client.execute(new HttpGet(queryUrl));

            JsonNode getRecentUploads;
            try {
                getRecentUploads = JsonUtils.DefaultObjectMapperHolder.mapper.readTree(response.getEntity().getContent());
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return new EntityResponseWrapper<>(response, getRecentUploads);
        });
    }
}
