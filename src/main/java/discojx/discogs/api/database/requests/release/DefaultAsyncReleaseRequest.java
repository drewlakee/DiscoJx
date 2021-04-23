package discojx.discogs.api.database.requests.release;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsEndpoints;
import discojx.discogs.objects.MarketplaceCurrencies;
import discojx.discogs.objects.Release;
import discojx.utils.requests.RequestParametersConstructor;
import discojx.utils.requests.StringBuilderSequentialRequestParametersConstructor;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultAsyncReleaseRequest implements AsyncReleaseRequest {

    protected final AbstractHttpClient<HttpEntity> client;

    protected static final ObjectMapper jsonMapper = new JsonMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private final long releaseId;

    private final String queryUrl;

    public DefaultAsyncReleaseRequest(Builder builder) {
        this.client = builder.client;
        this.releaseId = builder.releaseId;
        this.queryUrl = builder.queryUrl;
    }

    public static class Builder implements AsyncReleaseRequestBuilder {

        private final AbstractHttpClient<HttpEntity> client;

        private long releaseId;
        private MarketplaceCurrencies currAbbr;

        private String queryUrl;

        public Builder(AbstractHttpClient<HttpEntity> client) {
            this.client = client;
        }

        @Override
        public AsyncReleaseRequestBuilder releaseId(long releaseId) {
            this.releaseId = releaseId;
            return this;
        }

        @Override
        public AsyncReleaseRequestBuilder currAbbr(MarketplaceCurrencies currAbbr) {
            this.currAbbr = currAbbr;
            return this;
        }

        @Override
        public AsyncReleaseRequest build() {
            this.queryUrl = DiscogsEndpoints.DATABASE_RELEASE.getEndpointWith(constructParameters().toParametersString());
            return new DefaultAsyncReleaseRequest(this);
        }

        @Override
        public RequestParametersConstructor constructParameters() {
            StringBuilderSequentialRequestParametersConstructor parameters =
                    new StringBuilderSequentialRequestParametersConstructor();

            if (currAbbr != null) parameters.append("curr_abbr", currAbbr.name());

            return parameters;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "client=" + client +
                    ", releaseId=" + releaseId +
                    ", currAbbr=" + currAbbr +
                    ", queryUrl='" + queryUrl + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return releaseId == builder.releaseId && Objects.equals(client, builder.client) && currAbbr == builder.currAbbr && Objects.equals(queryUrl, builder.queryUrl);
        }

        @Override
        public int hashCode() {
            return Objects.hash(client, releaseId, currAbbr, queryUrl);
        }
    }

    @Override
    public CompletableFuture<Release> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            Optional<HttpEntity> execute = client.execute(new HttpGet(queryUrl.replace("{release_id}", String.valueOf(releaseId))));
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            Release release;
            try {
                release = jsonMapper.readValue(httpEntity.getContent(), Release.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return release;
        });
    }

    @Override
    public String toString() {
        return "DefaultAsyncReleaseRequest{" +
                "client=" + client +
                ", releaseId=" + releaseId +
                ", queryUrl='" + queryUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultAsyncReleaseRequest that = (DefaultAsyncReleaseRequest) o;
        return releaseId == that.releaseId && Objects.equals(client, that.client) && Objects.equals(queryUrl, that.queryUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, releaseId, queryUrl);
    }
}
