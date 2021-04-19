package discojx.discogs.api.database.requests.release.stats;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsEndpoints;
import discojx.discogs.objects.ReleaseStats;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultAsyncReleaseStatsRequest implements AsyncReleaseStatsRequest {

    protected final AbstractHttpClient<HttpEntity> client;

    protected static final ObjectMapper jsonMapper = new JsonMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private final long releaseId;

    public DefaultAsyncReleaseStatsRequest(Builder builder) {
        this.client = builder.client;
        this.releaseId = builder.releaseId;
    }

    public static class Builder implements AsyncReleaseStatsRequestBuilder {

        private final AbstractHttpClient<HttpEntity> client;

        private long releaseId;

        public Builder(AbstractHttpClient<HttpEntity> client) {
            this.client = client;
        }

        @Override
        public AsyncReleaseStatsRequestBuilder releaseId(long releaseId) {
            this.releaseId = releaseId;
            return this;
        }

        @Override
        public AsyncReleaseStatsRequest build() {
            return new DefaultAsyncReleaseStatsRequest(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "client=" + client +
                    ", releaseId=" + releaseId +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return releaseId == builder.releaseId && Objects.equals(client, builder.client);
        }

        @Override
        public int hashCode() {
            return Objects.hash(client, releaseId);
        }
    }

    @Override
    public CompletableFuture<ReleaseStats> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            Optional<HttpEntity> execute = client.execute(new HttpGet(DiscogsEndpoints.DATABASE_RELEASE_STATS.getEndpoint().replace("{release_id}", String.valueOf(releaseId))));
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            ReleaseStats releaseStats;
            try {
                releaseStats = jsonMapper.readValue(httpEntity.getContent(), ReleaseStats.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return releaseStats;
        });
    }

    @Override
    public String toString() {
        return "DefaultAsyncReleaseStatsRequest{" +
                "client=" + client +
                ", releaseId=" + releaseId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultAsyncReleaseStatsRequest that = (DefaultAsyncReleaseStatsRequest) o;
        return releaseId == that.releaseId && Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, releaseId);
    }
}
