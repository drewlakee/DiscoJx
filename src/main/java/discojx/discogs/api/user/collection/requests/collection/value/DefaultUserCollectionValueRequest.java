package discojx.discogs.api.user.collection.requests.collection.value;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.models.UserCollectionValue;
import discojx.requests.AbstractRequest;
import discojx.requests.AbstractRequestBuilder;
import discojx.utils.json.JsonUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultUserCollectionValueRequest extends AbstractRequest
        implements UserCollectionValueRequest {

    public DefaultUserCollectionValueRequest(AbstractRequestBuilder builder) {
        super(builder);
    }

    public static class Builder extends AbstractRequestBuilder
            implements UserCollectionValueRequestBuilder {

        private String username;

        public Builder(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public UserCollectionValueRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        @Override
        public UserCollectionValueRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .USER_COLLECTION_VALUE
                    .getEndpoint()
                    .replace("{username}", username);
            return new DefaultUserCollectionValueRequest(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "username='" + username + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Builder builder = (Builder) o;
            return Objects.equals(username, builder.username);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), username);
        }
    }

    @Override
    public CompletableFuture<UserCollectionValue> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            HttpResponse response = client.execute(new HttpGet(queryUrl));

            UserCollectionValue userCollectionValue;
            try {
                userCollectionValue = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(response.getEntity().getContent(), UserCollectionValue.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return userCollectionValue;
        });
    }
}
