package discojx.discogs.api.database.requests.release.rating.community;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.CommunityReleaseRating;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultCommunityReleaseRatingRequest implements CommunityReleaseRatingRequest {

    protected final AbstractHttpClient<HttpEntity> client;

    protected static final ObjectMapper jsonMapper = new JsonMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private final long releaseId;

    public DefaultCommunityReleaseRatingRequest(Builder builder) {
        this.client = builder.client;
        this.releaseId = builder.releaseId;
    }

    public static class Builder implements CommunityReleaseRatingRequestBuilder {

        private final AbstractHttpClient<HttpEntity> client;

        private long releaseId;

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
    public CompletableFuture<CommunityReleaseRating> supplyFuture() {
        return CompletableFuture.supplyAsync(() -> {
            Optional<HttpEntity> execute = client.execute(new HttpGet(DiscogsApiEndpoints.DATABASE_COMMUNITY_RELEASE_RATING.getEndpoint().replace("{release_id}", String.valueOf(releaseId))));
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            CommunityReleaseRating communityReleaseRating;
            try {
                communityReleaseRating = jsonMapper.readValue(httpEntity.getContent(), CommunityReleaseRating.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return communityReleaseRating;
        });
    }

    @Override
    public String toString() {
        return "DefaultCommunityReleaseRequest{" +
                "client=" + client +
                ", releaseId=" + releaseId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultCommunityReleaseRatingRequest that = (DefaultCommunityReleaseRatingRequest) o;
        return releaseId == that.releaseId && Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, releaseId);
    }
}
