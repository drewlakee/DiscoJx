package discojx.discogs.api.database.requests.release.rating.user.edit;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.ReleaseRating;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultReleaseRatingUpdateByUserRequest implements ReleaseRatingUpdateByUserRequest {

    protected final AbstractHttpClient<HttpEntity> client;

    protected static final ObjectMapper jsonMapper = new JsonMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private final long releaseId;
    private final String username;
    private final int rating;

    public DefaultReleaseRatingUpdateByUserRequest(Builder builder) {
        this.client = builder.client;
        this.releaseId = builder.releaseId;
        this.username = builder.username;
        this.rating = builder.rating;
    }

    public static class Builder implements ReleaseRatingUpdateByUserRequestBuilder {

        private final AbstractHttpClient<HttpEntity> client;

        private long releaseId;
        private String username;
        private int rating;

        public Builder(AbstractHttpClient<HttpEntity> client) {
            this.client = client;
        }

        @Override
        public ReleaseRatingUpdateByUserRequestBuilder releaseId(long releaseId) {
            this.releaseId = releaseId;
            return this;
        }

        @Override
        public ReleaseRatingUpdateByUserRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        @Override
        public ReleaseRatingUpdateByUserRequestBuilder rating(int rating) {
            this.rating = rating;
            return this;
        }

        @Override
        public ReleaseRatingUpdateByUserRequest build() {
            return new DefaultReleaseRatingUpdateByUserRequest(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "client=" + client +
                    ", releaseId=" + releaseId +
                    ", username='" + username + '\'' +
                    ", rating=" + rating +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return releaseId == builder.releaseId && Double.compare(builder.rating, rating) == 0 && Objects.equals(client, builder.client) && Objects.equals(username, builder.username);
        }

        @Override
        public int hashCode() {
            return Objects.hash(client, releaseId, username, rating);
        }
    }

    @Override
    public CompletableFuture<ReleaseRating> supplyFuture() {
        return CompletableFuture.supplyAsync(() -> {
            String endpoint = DiscogsApiEndpoints.DATABASE_RELEASE_RATING_BY_USER.getEndpoint()
                    .replace("{release_id}", String.valueOf(releaseId))
                    .replace("{username}", username);

            HttpPut request = new HttpPut(endpoint);

            ObjectNode jsonObject = JsonNodeFactory.instance.objectNode();
            jsonObject.put("rating", rating);

            request.setHeader("Content-Type", "application/json");
            request.setEntity(new StringEntity(jsonObject.toString(), "UTF-8"));

            Optional<HttpEntity> execute = client.execute(request);
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            ReleaseRating releaseRating;
            try {
                releaseRating = jsonMapper.readValue(httpEntity.getContent(), ReleaseRating.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return releaseRating;
        });
    }

    @Override
    public String toString() {
        return "DefaultReleaseRatingUpdateByUserRequest{" +
                "client=" + client +
                ", releaseId=" + releaseId +
                ", username='" + username + '\'' +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultReleaseRatingUpdateByUserRequest that = (DefaultReleaseRatingUpdateByUserRequest) o;
        return releaseId == that.releaseId && Double.compare(that.rating, rating) == 0 && Objects.equals(client, that.client) && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, releaseId, username, rating);
    }
}
