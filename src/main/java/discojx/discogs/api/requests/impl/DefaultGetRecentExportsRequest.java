package discojx.discogs.api.requests.impl;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.api.endpoints.inventory.export.requests.recent.GetRecentExportsRequest;
import discojx.discogs.api.endpoints.inventory.export.requests.recent.GetRecentExportsRequestBuilder;
import discojx.discogs.objects.requests.GetRecentExports;
import discojx.discogs.api.requests.AbstractPathParameterizedRequestBuilder;
import discojx.discogs.api.requests.AbstractRequest;
import discojx.discogs.api.requests.AbstractRequestBuilder;
import discojx.utils.json.JsonUtils;
import discojx.utils.requests.RequestPathParametersConstructor;
import discojx.utils.requests.StringBuilderSequentialRequestPathParametersConstructor;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultGetRecentExportsRequest extends AbstractRequest
        implements GetRecentExportsRequest {

    public DefaultGetRecentExportsRequest(AbstractRequestBuilder builder) {
        super(builder);
    }

    public static class Builder extends AbstractPathParameterizedRequestBuilder<RequestPathParametersConstructor>
            implements GetRecentExportsRequestBuilder {

        private int page;
        private int perPage;

        public Builder(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public GetRecentExportsRequestBuilder page(int page) {
            this.page = page;
            return this;
        }

        @Override
        public GetRecentExportsRequestBuilder perPage(int perPage) {
            this.perPage = perPage;
            return this;
        }

        @Override
        public GetRecentExportsRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .INVENTORY_EXPORT_GET_RECENT_EXPORTS
                    .getEndpointWith(constructPathParameters().toParametersString());
            return new DefaultGetRecentExportsRequest(this);
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
    public CompletableFuture<GetRecentExports> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            HttpResponse response = client.execute(new HttpGet(queryUrl));

            GetRecentExports getRecentExports;
            try {
                getRecentExports = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(response.getEntity().getContent(), GetRecentExports.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return getRecentExports;
        });
    }
}
