package discojx.discogs.api.user.collection.requests.collection.folder.release;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.UserReleaseCollectionItems;
import discojx.requests.AbstractPathParameterizedRequestBuilder;
import discojx.requests.AbstractRequest;
import discojx.requests.AbstractRequestBuilder;
import discojx.utils.json.JsonUtils;
import discojx.utils.requests.RequestPathParametersConstructor;
import discojx.utils.requests.StringBuilderSequentialRequestPathParametersConstructor;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultUserReleaseFolderCollectionItemsRequest extends AbstractRequest
        implements UserReleaseFolderCollectionItemsRequest {

    public DefaultUserReleaseFolderCollectionItemsRequest(AbstractRequestBuilder builder) {
        super(builder);
    }

    public static class Builder extends AbstractPathParameterizedRequestBuilder<RequestPathParametersConstructor>
            implements UserReleaseFolderCollectionItemsRequestBuilder {

        private int page;
        private int perPage;
        private String username;
        private long folderId;
        private String sort;
        private String sortOrder;

        public Builder(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public UserReleaseFolderCollectionItemsRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        @Override
        public UserReleaseFolderCollectionItemsRequestBuilder folderId(long folderId) {
            this.folderId = folderId;
            return this;
        }

        @Override
        public UserReleaseFolderCollectionItemsRequestBuilder page(int page) {
            this.page = page;
            return this;
        }

        @Override
        public UserReleaseFolderCollectionItemsRequestBuilder perPage(int perPage) {
            this.perPage = perPage;
            return this;
        }

        @Override
        public UserReleaseFolderCollectionItemsRequestBuilder sort(String attribute) {
            this.sort = attribute;
            return this;
        }

        @Override
        public UserReleaseFolderCollectionItemsRequestBuilder sortOrder(String sortOrder) {
            this.sortOrder = sortOrder;
            return this;
        }

        @Override
        public UserReleaseFolderCollectionItemsRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .USER_COLLECTION_RELEASE_ITEMS_BY_FOLDER
                    .getEndpointWith(constructPathParameters().toParametersString())
                    .replace("{username}", username)
                    .replace("{folder_id}", String.valueOf(folderId));
            return new DefaultUserReleaseFolderCollectionItemsRequest(this);
        }

        @Override
        public RequestPathParametersConstructor constructPathParameters() {
            StringBuilderSequentialRequestPathParametersConstructor parameters =
                    new StringBuilderSequentialRequestPathParametersConstructor();

            if (page > 0) parameters.append("page", page);
            if (perPage > 0) parameters.append("per_page", perPage);
            if (sort != null) parameters.append("sort", sort);
            if (sortOrder != null) parameters.append("sort_order", sortOrder);

            return parameters;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "page=" + page +
                    ", perPage=" + perPage +
                    ", username='" + username + '\'' +
                    ", folderId=" + folderId +
                    ", sort='" + sort + '\'' +
                    ", sortOrder='" + sortOrder + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Builder builder = (Builder) o;
            return page == builder.page && perPage == builder.perPage && folderId == builder.folderId && Objects.equals(username, builder.username) && Objects.equals(sort, builder.sort) && Objects.equals(sortOrder, builder.sortOrder);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), page, perPage, username, folderId, sort, sortOrder);
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
