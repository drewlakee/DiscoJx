package discojx.discogs.api.database.requests.release;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.MarketplaceCurrencies;
import discojx.discogs.objects.Release;
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

public class DefaultReleaseRequest extends AbstractRequest<HttpEntity>
        implements ReleaseRequest {

    public DefaultReleaseRequest(Builder builder) {
        super(builder);
    }

    public static class Builder extends AbstractPathParameterizedRequestBuilder<HttpEntity, RequestPathParametersConstructor>
            implements ReleaseRequestBuilder {

        private long releaseId;
        private MarketplaceCurrencies currAbbr;

        public Builder(AbstractHttpClient<HttpEntity> client) {
            super(client);
        }

        @Override
        public ReleaseRequestBuilder releaseId(long releaseId) {
            this.releaseId = releaseId;
            return this;
        }

        @Override
        public ReleaseRequestBuilder currAbbr(MarketplaceCurrencies currAbbr) {
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

            if (currAbbr != null) parameters.append("curr_abbr", currAbbr.name());

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
            return releaseId == builder.releaseId && currAbbr == builder.currAbbr;
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), releaseId, currAbbr);
        }
    }

    @Override
    public CompletableFuture<Release> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            Optional<HttpEntity> execute = client.execute(new HttpGet(queryUrl));
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            Release release;
            try {
                release = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(httpEntity.getContent(), Release.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return release;
        });
    }
}
