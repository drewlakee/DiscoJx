package discojx.discogs.api.database.requests.release.rating.community;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.CommunityReleaseRating;
import discojx.utils.json.JsonUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultCommunityReleaseRatingRequest implements CommunityReleaseRatingRequest {

    protected final AbstractHttpClient<HttpEntity> client;

    private final String queryUrl;

    public DefaultCommunityReleaseRatingRequest(Builder builder) {
        this.client = builder.client;
        this.queryUrl = builder.queryUrl;
    }

    public static class Builder implements CommunityReleaseRatingRequestBuilder {

        private final AbstractHttpClient<HttpEntity> client;

        private long releaseId;

        private String queryUrl;

        public Builder(AbstractHttpClient<HttpEntity> client) {
            this.client = client;
        }

        @Override
        public CommunityReleaseRatingRequestBuilder releaseId(long releaseId) {
            this.releaseId = releaseId;
            return this;
        }

        @Override
        public CommunityReleaseRatingRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .DATABASE_COMMUNITY_RELEASE_RATING
                    .getEndpoint()
                    .replace("{release_id}", String.valueOf(releaseId));
            return new DefaultCommunityReleaseRatingRequest(this);
        }

        public AbstractHttpClient<HttpEntity> getClient() {
            return client;
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
    public CompletableFuture<CommunityReleaseRating> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            Optional<HttpEntity> execute = client.execute(new HttpGet(queryUrl));
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            CommunityReleaseRating communityReleaseRating;
            try {
                communityReleaseRating = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(httpEntity.getContent(), CommunityReleaseRating.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return communityReleaseRating;
        });
    }

    @Override
    public String toString() {
        return "DefaultCommunityReleaseRatingRequest{" +
                "client=" + client +
                ", queryUrl='" + queryUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultCommunityReleaseRatingRequest that = (DefaultCommunityReleaseRatingRequest) o;
        return Objects.equals(client, that.client) && Objects.equals(queryUrl, that.queryUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, queryUrl);
    }
}
