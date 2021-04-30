package discojx.discogs.api.database.requests.release.stats;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.ReleaseStats;
import discojx.requests.AbstractRequest;
import discojx.requests.AbstractRequestBuilder;
import discojx.utils.json.JsonUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultReleaseStatsRequest extends AbstractRequest
        implements ReleaseStatsRequest {

    public DefaultReleaseStatsRequest(Builder builder) {
        super(builder);
    }

    public static class Builder extends AbstractRequestBuilder
            implements ReleaseStatsRequestBuilder {

        private long releaseId;

        public Builder(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public ReleaseStatsRequestBuilder releaseId(long releaseId) {
            this.releaseId = releaseId;
            return this;
        }

        @Override
        public ReleaseStatsRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .DATABASE_RELEASE_STATS
                    .getEndpoint()
                    .replace("{release_id}", String.valueOf(releaseId));
            return new DefaultReleaseStatsRequest(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "client=" + client +
                    ", releaseId=" + releaseId +
                    ", queryUrl='" + queryUrl + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return releaseId == builder.releaseId && Objects.equals(client, builder.client) && Objects.equals(queryUrl, builder.queryUrl);
        }

        @Override
        public int hashCode() {
            return Objects.hash(client, releaseId, queryUrl);
        }
    }

    @Override
    public CompletableFuture<ReleaseStats> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            HttpResponse response = client.execute(new HttpGet(queryUrl));

            ReleaseStats releaseStats;
            try {
                releaseStats = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(response.getEntity().getContent(), ReleaseStats.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return releaseStats;
        });
    }
}
