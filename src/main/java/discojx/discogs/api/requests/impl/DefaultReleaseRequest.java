package discojx.discogs.api.requests.impl;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.api.endpoints.database.requests.release.ReleaseRequest;
import discojx.discogs.api.endpoints.database.requests.release.ReleaseRequestBuilder;
import discojx.discogs.api.requests.AbstractPathParameterizedRequestBuilder;
import discojx.discogs.api.requests.AbstractRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.Release;
import discojx.utils.json.JsonUtils;
import discojx.utils.requests.RequestPathParametersConstructor;
import discojx.utils.requests.StringBuilderSequentialRequestPathParametersConstructor;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultReleaseRequest extends AbstractRequest
        implements ReleaseRequest {

    public DefaultReleaseRequest(Builder builder) {
        super(builder);
    }

    public static class Builder extends AbstractPathParameterizedRequestBuilder<RequestPathParametersConstructor>
            implements ReleaseRequestBuilder {

        private long releaseId;
        private String currAbbr;

        public Builder(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public ReleaseRequestBuilder releaseId(long releaseId) {
            this.releaseId = releaseId;
            return this;
        }

        @Override
        public ReleaseRequestBuilder currAbbr(String currAbbr) {
            this.currAbbr = currAbbr;
            return this;
        }

        @Override
        public ReleaseRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .DATABASE_RELEASE
                    .getEndpointWith(constructPathParameters().toParametersString())
                    .replace("{release_id}", String.valueOf(releaseId));
            return new DefaultReleaseRequest(this);
        }

        @Override
        public RequestPathParametersConstructor constructPathParameters() {
            StringBuilderSequentialRequestPathParametersConstructor parameters =
                    new StringBuilderSequentialRequestPathParametersConstructor();

            if (currAbbr != null) parameters.append("curr_abbr", currAbbr);

            return parameters;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "releaseId=" + releaseId +
                    ", currAbbr=" + currAbbr +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Builder builder = (Builder) o;
            return releaseId == builder.releaseId && currAbbr.equals(builder.currAbbr);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), releaseId, currAbbr);
        }
    }

    @Override
    public CompletableFuture<EntityResponseWrapper<Release>> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            HttpResponse response = client.execute(new HttpGet(queryUrl));

            Release release;
            try {
                release = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(response.getEntity().getContent(), Release.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return new EntityResponseWrapper<>(response, release);
        });
    }
}
