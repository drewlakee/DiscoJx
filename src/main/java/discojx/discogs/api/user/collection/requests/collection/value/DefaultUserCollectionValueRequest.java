package discojx.discogs.api.user.collection.requests.collection.value;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.UserCollectionValue;
import discojx.discogs.objects.UserFolders;
import discojx.requests.AbstractRequest;
import discojx.requests.AbstractRequestBuilder;
import discojx.utils.json.JsonUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultUserCollectionValueRequest extends AbstractRequest<HttpEntity>
        implements UserCollectionValueRequest {

    public DefaultUserCollectionValueRequest(AbstractRequestBuilder<HttpEntity> builder) {
        super(builder);
    }

    public static class Builder extends AbstractRequestBuilder<HttpEntity>
            implements UserCollectionValueRequestBuilder {

        private String username;

        public Builder(AbstractHttpClient<HttpEntity> client) {
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
            Optional<HttpEntity> execute = client.execute(new HttpGet(queryUrl));
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            UserCollectionValue userCollectionValue;
            try {
                userCollectionValue = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(httpEntity.getContent(), UserCollectionValue.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return userCollectionValue;
        });
    }
}
