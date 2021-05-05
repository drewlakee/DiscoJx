package discojx.discogs.api.requests.impl;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.api.endpoints.user.collection.requests.release.UserReleaseCollectionItemsRequest;
import discojx.discogs.api.endpoints.user.collection.requests.release.UserReleaseCollectionItemsRequestBuilder;
import discojx.discogs.objects.models.UserReleaseCollectionItems;
import discojx.discogs.api.requests.AbstractPathParameterizedRequestBuilder;
import discojx.discogs.api.requests.AbstractRequest;
import discojx.discogs.api.requests.AbstractRequestBuilder;
import discojx.utils.json.JsonUtils;
import discojx.utils.requests.RequestPathParametersConstructor;
import discojx.utils.requests.StringBuilderSequentialRequestPathParametersConstructor;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultUserReleaseCollectionItemsRequest extends AbstractRequest
        implements UserReleaseCollectionItemsRequest {

    public DefaultUserReleaseCollectionItemsRequest(AbstractRequestBuilder builder) {
        super(builder);
    }

    public static class Builder extends AbstractPathParameterizedRequestBuilder<RequestPathParametersConstructor>
            implements UserReleaseCollectionItemsRequestBuilder {

        private int page;
        private int perPage;
        private String username;
        private long releaseId;

        public Builder(AbstractHttpClient client) {
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
                    .USER_COLLECTION_RELEASE_ITEMS_BY_RELEASE
                    .getEndpointWith(constructPathParameters().toParametersString())
                    .replace("{username}", username)
                    .replace("{release_id}", String.valueOf(releaseId));
            return new DefaultUserReleaseCollectionItemsRequest(this);
        }

        @Override
        public RequestPathParametersConstructor constructPathParameters() {
            StringBuilderSequentialRequestPathParametersConstructor parameters =
                    new StringBuilderSequentialRequestPathParametersConstructor();

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
            HttpResponse response = client.execute(new HttpGet(queryUrl));

            UserReleaseCollectionItems userReleaseCollectionItems;
            try {
                userReleaseCollectionItems = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(response.getEntity().getContent(), UserReleaseCollectionItems.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return userReleaseCollectionItems;
        });
    }
}
