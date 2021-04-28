package discojx.discogs.api.user.collection.requests.collection.release;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.UserFolders;
import discojx.discogs.objects.UserReleaseCollectionItems;
import discojx.requests.AbstractPathParameterizedRequestBuilder;
import discojx.requests.AbstractRequest;
import discojx.requests.AbstractRequestBuilder;
import discojx.utils.json.JsonUtils;
import discojx.utils.requests.RequestParametersConstructor;
import discojx.utils.requests.StringBuilderSequentialRequestParametersConstructor;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultUserReleaseCollectionItemsRequest extends AbstractRequest<HttpEntity>
        implements UserReleaseCollectionItemsRequest {

    public DefaultUserReleaseCollectionItemsRequest(AbstractRequestBuilder<HttpEntity> builder) {
        super(builder);
    }

    public static class Builder extends AbstractPathParameterizedRequestBuilder<HttpEntity, RequestParametersConstructor>
            implements UserReleaseCollectionItemsRequestBuilder {

        private int page;
        private int perPage;
        private String username;
        private long releaseId;

        public Builder(AbstractHttpClient<HttpEntity> client) {
            super(client);
        }

        @Override
        public UserReleaseCollectionItemsRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        @Override
        public UserReleaseCollectionItemsRequestBuilder releaseId(long releaseId) {
            this.releaseId = releaseId;
            return this;
        }

        @Override
        public UserReleaseCollectionItemsRequestBuilder page(int page) {
            this.page = page;
            return this;
        }

        @Override
        public UserReleaseCollectionItemsRequestBuilder perPage(int perPage) {
            this.perPage = perPage;
            return null;
        }

        @Override
        public UserReleaseCollectionItemsRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .USER_COLLECTION_RELEASE_ITEMS
                    .getEndpointWith(constructPathParameters().toParametersString())
                    .replace("{username}", username)
                    .replace("{release_id}", String.valueOf(releaseId));
            return new DefaultUserReleaseCollectionItemsRequest(this);
        }

        @Override
        public RequestParametersConstructor constructPathParameters() {
            StringBuilderSequentialRequestParametersConstructor parameters =
                    new StringBuilderSequentialRequestParametersConstructor();

            if (page > 0) parameters.append("page", page);
            if (perPage > 0) parameters.append("per_page", perPage);

            return parameters;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "page=" + page +
                    ", perPage=" + perPage +
                    ", username='" + username + '\'' +
                    ", releaseId=" + releaseId +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Builder builder = (Builder) o;
            return page == builder.page && perPage == builder.perPage && releaseId == builder.releaseId && Objects.equals(username, builder.username);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), page, perPage, username, releaseId);
        }
    }

    @Override
    public CompletableFuture<UserReleaseCollectionItems> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            Optional<HttpEntity> execute = client.execute(new HttpGet(queryUrl));
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            UserReleaseCollectionItems userReleaseCollectionItems;
            try {
                userReleaseCollectionItems = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(httpEntity.getContent(), UserReleaseCollectionItems.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return userReleaseCollectionItems;
        });
    }
}
