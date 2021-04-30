package discojx.discogs.api.user.wantlist.requests.edit;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.UserWant;
import discojx.requests.AbstractJsonParameterizedRequest;
import discojx.requests.AbstractJsonParameterizedRequestBuilder;
import discojx.utils.json.JsonUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultEditUserWantListRequest extends AbstractJsonParameterizedRequest<ObjectNode>
        implements EditUserWantListRequest {

    public DefaultEditUserWantListRequest(Builder builder) {
        super(builder);
    }

    public static class Builder extends AbstractJsonParameterizedRequestBuilder<ObjectNode>
            implements EditUserWantListRequestBuilder {

        private String username;
        private String notes;
        private int rating;
        private long releaseId;

        public Builder(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public EditUserWantListRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        @Override
        public EditUserWantListRequestBuilder releaseId(long releaseId) {
            this.releaseId = releaseId;
            return this;
        }

        @Override
        public EditUserWantListRequestBuilder notes(String notes) {
            this.notes = notes;
            return this;
        }

        @Override
        public EditUserWantListRequestBuilder rating(int rating) {
            this.rating = rating;
            return this;
        }

        @Override
        public EditUserWantListRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .USER_EDIT_WANT_LIST
                    .getEndpoint()
                    .replace("{username}", username)
                    .replace("{release_id}", String.valueOf(releaseId));
            this.jsonObject = constructJsonParameters();
            return new DefaultEditUserWantListRequest(this);
        }

        @Override
        public ObjectNode constructJsonParameters() {
            ObjectNode jsonObject = JsonNodeFactory.instance.objectNode();

            if (notes != null) jsonObject.put("notes", notes);
            if (rating > -1) jsonObject.put("rating", rating);

            return jsonObject;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "client=" + client +
                    ", username='" + username + '\'' +
                    ", notes='" + notes + '\'' +
                    ", rating=" + rating +
                    ", releaseId=" + releaseId +
                    ", queryUrl='" + queryUrl + '\'' +
                    ", jsonObject=" + jsonObject +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return rating == builder.rating && releaseId == builder.releaseId && Objects.equals(client, builder.client) && Objects.equals(username, builder.username) && Objects.equals(notes, builder.notes) && Objects.equals(queryUrl, builder.queryUrl) && Objects.equals(jsonObject, builder.jsonObject);
        }

        @Override
        public int hashCode() {
            return Objects.hash(client, username, notes, rating, releaseId, queryUrl, jsonObject);
        }
    }

    @Override
    public CompletableFuture<UserWant> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            HttpPost request = new HttpPost(queryUrl);
            request.setHeader("Content-Type", "application/json");
            request.setEntity(new StringEntity(jsonObject.toString(), "UTF-8"));
            HttpResponse response = client.execute(request);

            UserWant userWant;
            try {
                userWant = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(response.getEntity().getContent(), UserWant.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return userWant;
        });
    }
}
