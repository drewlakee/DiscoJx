package discojx.discogs.api.user.collection.requests.collection.fields.edit;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.requests.AbstractJsonParameterizedRequest;
import discojx.requests.AbstractJsonParameterizedRequestBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class DefaultEditFieldsInstanceRequest extends AbstractJsonParameterizedRequest<ObjectNode>
        implements EditFieldsInstanceRequest {

    public DefaultEditFieldsInstanceRequest(AbstractJsonParameterizedRequestBuilder<ObjectNode> builder) {
        super(builder);
    }

    public static class Builder extends AbstractJsonParameterizedRequestBuilder<ObjectNode>
            implements EditFieldsInstanceRequestBuilder {

        private String username;
        private String value;
        private long folderId;
        private long releaseId;
        private long instanceId;
        private long fieldId;

        public Builder(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public EditFieldsInstanceRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        @Override
        public EditFieldsInstanceRequestBuilder value(String value) {
            this.value = value;
            return this;
        }

        @Override
        public EditFieldsInstanceRequestBuilder folderId(long folderId) {
            this.folderId = folderId;
            return this;
        }

        @Override
        public EditFieldsInstanceRequestBuilder releaseId(long releaseId) {
            this.releaseId = releaseId;
            return this;
        }

        @Override
        public EditFieldsInstanceRequestBuilder instanceId(long instanceId) {
            this.instanceId = instanceId;
            return this;
        }

        @Override
        public EditFieldsInstanceRequestBuilder fieldId(long fieldId) {
            this.fieldId = fieldId;
            return this;
        }

        @Override
        public EditFieldsInstanceRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .USER_COLLECTION_EDIT_FIELDS_INSTANCE
                    .getEndpoint()
                    .replace("{username}", username)
                    .replace("{folder_id}", String.valueOf(folderId))
                    .replace("{release_id}", String.valueOf(releaseId))
                    .replace("{instance_id}", String.valueOf(instanceId))
                    .replace("{field_id}", String.valueOf(fieldId));
            this.jsonObject = constructJsonParameters();
            return new DefaultEditFieldsInstanceRequest(this);
        }

        @Override
        protected ObjectNode constructJsonParameters() {
            ObjectNode jsonObject = JsonNodeFactory.instance.objectNode();

            if (value != null) jsonObject.put("value", value);

            return jsonObject;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "username='" + username + '\'' +
                    ", value='" + value + '\'' +
                    ", folderId=" + folderId +
                    ", releaseId=" + releaseId +
                    ", instanceId=" + instanceId +
                    ", fieldId=" + fieldId +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Builder builder = (Builder) o;
            return folderId == builder.folderId && releaseId == builder.releaseId && instanceId == builder.instanceId && fieldId == builder.fieldId && Objects.equals(username, builder.username) && Objects.equals(value, builder.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), username, value, folderId, releaseId, instanceId, fieldId);
        }
    }

    @Override
    public CompletableFuture<Void> executeAsync() {
        return CompletableFuture.runAsync(() -> {
            HttpPost request = new HttpPost(queryUrl);
            request.setHeader("Content-Type", "application/json");
            request.setEntity(new StringEntity(jsonObject.toString(), "UTF-8"));
            client.execute(request);
        });
    }
}
