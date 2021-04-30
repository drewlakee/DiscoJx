package discojx.discogs.api.user.collection.requests.collection.release.rating;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.requests.AbstractJsonParameterizedRequest;
import discojx.requests.AbstractJsonParameterizedRequestBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class DefaultChangeReleaseRatingRequest extends AbstractJsonParameterizedRequest<ObjectNode>
        implements ChangeReleaseRatingRequest {

    public DefaultChangeReleaseRatingRequest(AbstractJsonParameterizedRequestBuilder<ObjectNode> builder) {
        super(builder);
    }

    public static class Builder extends AbstractJsonParameterizedRequestBuilder<ObjectNode>
            implements ChangeReleaseRatingRequestBuilder {

        private String username;
        private long folderId;
        private long folderIdToReplace;
        private long releaseId;
        private long instanceId;
        private int rating;

        public Builder(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public ChangeReleaseRatingRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        @Override
        public ChangeReleaseRatingRequestBuilder folderId(long folderId) {
            this.folderId = folderId;
            return this;
        }

        @Override
        public ChangeReleaseRatingRequestBuilder folderIdToReplace(long folderIdToReplace) {
            this.folderIdToReplace = folderIdToReplace;
            return this;
        }

        @Override
        public ChangeReleaseRatingRequestBuilder releaseId(long releaseId) {
            this.releaseId = releaseId;
            return this;
        }

        @Override
        public ChangeReleaseRatingRequestBuilder instanceId(long instanceId) {
            this.instanceId = instanceId;
            return this;
        }

        @Override
        public ChangeReleaseRatingRequestBuilder rating(int rating) {
            this.rating = rating;
            return this;
        }

        @Override
        public ChangeReleaseRatingRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .USER_COLLECTION_CHANGE_RATING_OF_RELEASE
                    .getEndpoint()
                    .replace("{username}", username)
                    .replace("{folder_id}", String.valueOf(folderId))
                    .replace("{release_id}", String.valueOf(releaseId))
                    .replace("{instance_id}", String.valueOf(instanceId));
            this.jsonObject = constructJsonParameters();
            return new DefaultChangeReleaseRatingRequest(this);
        }

        @Override
        protected ObjectNode constructJsonParameters() {
            ObjectNode jsonObject = JsonNodeFactory.instance.objectNode();

            if (folderIdToReplace > 0) jsonObject.put("folder_id", folderIdToReplace);
            if (rating > -1) jsonObject.put("rating", rating);

            return jsonObject;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "username='" + username + '\'' +
                    ", folderId=" + folderId +
                    ", folderIdToReplace=" + folderIdToReplace +
                    ", releaseId=" + releaseId +
                    ", instanceId=" + instanceId +
                    ", rating=" + rating +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Builder builder = (Builder) o;
            return folderId == builder.folderId && folderIdToReplace == builder.folderIdToReplace && releaseId == builder.releaseId && instanceId == builder.instanceId && rating == builder.rating && Objects.equals(username, builder.username);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), username, folderId, folderIdToReplace, releaseId, instanceId, rating);
        }
    }

    @Override
    public CompletableFuture<HttpResponse> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            HttpPost request = new HttpPost(queryUrl);
            request.setHeader("Content-Type", "application/json");
            request.setEntity(new StringEntity(jsonObject.toString(), "UTF-8"));
            return client.execute(request);
        });
    }
}
