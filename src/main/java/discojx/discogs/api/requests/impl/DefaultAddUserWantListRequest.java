package discojx.discogs.api.requests.impl;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.api.endpoints.user.wantlist.requests.add.AddUserWantListRequest;
import discojx.discogs.api.endpoints.user.wantlist.requests.add.AddUserWantListRequestBuilder;
import discojx.discogs.api.requests.AbstractJsonParameterizedRequest;
import discojx.discogs.api.requests.AbstractJsonParameterizedRequestBuilder;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.UserWant;
import discojx.utils.json.JsonUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultAddUserWantListRequest extends AbstractJsonParameterizedRequest<ObjectNode>
        implements AddUserWantListRequest {

    public DefaultAddUserWantListRequest(Builder builder) {
        super(builder);
    }

    public static class Builder extends AbstractJsonParameterizedRequestBuilder<ObjectNode>
            implements AddUserWantListRequestBuilder {

        private String username;
        private long releaseId;
        private String notes;
        private int rating;

        public Builder(AbstractHttpClient client) {
            super(client);
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
            if (rating > -1) jsonObject.put("rating", rating);

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
    public CompletableFuture<EntityResponseWrapper<UserWant>> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            HttpPut request = new HttpPut(queryUrl);
            request.setHeader("Content-Type", "application/json");
            request.setEntity(new StringEntity(jsonObject.toString(), "UTF-8"));
            HttpResponse response = client.execute(request);

            UserWant userWant;
            try {
                userWant = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(response.getEntity().getContent(), UserWant.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return new EntityResponseWrapper<>(response, userWant);
        });
    }
}
