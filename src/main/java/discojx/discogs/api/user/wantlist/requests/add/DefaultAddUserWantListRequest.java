package discojx.discogs.api.user.wantlist.requests.add;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.UserWant;
import discojx.utils.json.JsonUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultAddUserWantListRequest implements AddUserWantListRequest {

    protected final AbstractHttpClient<HttpEntity> client;

    protected final String queryUrl;
    protected final ObjectNode jsonObject;

    public DefaultAddUserWantListRequest(Builder builder) {
        this.client = builder.client;
        this.queryUrl = builder.queryUrl;
        this.jsonObject = builder.jsonObject;
    }

    public static class Builder implements AddUserWantListRequestBuilder {

        private final AbstractHttpClient<HttpEntity> client;

        private String username;
        private long releaseId;
        private String notes;
        private int rating;

        private String queryUrl;
        private ObjectNode jsonObject;

        public Builder(AbstractHttpClient<HttpEntity> client) {
            this.client = client;
        }

        @Override
        public AddUserWantListRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        @Override
        public AddUserWantListRequestBuilder releaseId(long releaseId) {
            this.releaseId = releaseId;
            return this;
        }

        @Override
        public AddUserWantListRequestBuilder notes(String notes) {
            this.notes = notes;
            return this;
        }

        @Override
        public AddUserWantListRequestBuilder rating(int rating) {
            this.rating = rating;
            return this;
        }

        @Override
        public AddUserWantListRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .USER_ADD_WANT_LIST.getEndpoint()
                    .replace("{username}", username)
                    .replace("{release_id}", String.valueOf(releaseId));
            this.jsonObject = constructJsonParameters();
            return new DefaultAddUserWantListRequest(this);
        }

        @Override
        public ObjectNode constructJsonParameters() {
            ObjectNode jsonObject = JsonNodeFactory.instance.objectNode();

            if (notes != null) jsonObject.put("notes", notes);
            if (rating > 0) jsonObject.put("rating", rating);

            return jsonObject;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "client=" + client +
                    ", username='" + username + '\'' +
                    ", releaseId=" + releaseId +
                    ", notes='" + notes + '\'' +
                    ", rating=" + rating +
                    ", queryUrl='" + queryUrl + '\'' +
                    ", jsonObject=" + jsonObject +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return releaseId == builder.releaseId && rating == builder.rating && Objects.equals(client, builder.client) && Objects.equals(username, builder.username) && Objects.equals(notes, builder.notes) && Objects.equals(queryUrl, builder.queryUrl) && Objects.equals(jsonObject, builder.jsonObject);
        }

        @Override
        public int hashCode() {
            return Objects.hash(client, username, releaseId, notes, rating, queryUrl, jsonObject);
        }
    }

    @Override
    public CompletableFuture<UserWant> supplyFuture() {
        return CompletableFuture.supplyAsync(() -> {
            HttpPut request = new HttpPut(queryUrl);
            request.setHeader("Content-Type", "application/json");
            request.setEntity(new StringEntity(jsonObject.toString(), "UTF-8"));
            Optional<HttpEntity> execute = client.execute(request);
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            UserWant userWant;
            try {
                userWant = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(httpEntity.getContent(), UserWant.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return userWant;
        });
    }

    @Override
    public String toString() {
        return "DefaultAddUserWantListRequest{" +
                "client=" + client +
                ", queryUrl='" + queryUrl + '\'' +
                ", jsonObject=" + jsonObject +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultAddUserWantListRequest that = (DefaultAddUserWantListRequest) o;
        return Objects.equals(client, that.client) && Objects.equals(queryUrl, that.queryUrl) && Objects.equals(jsonObject, that.jsonObject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, queryUrl, jsonObject);
    }
}
