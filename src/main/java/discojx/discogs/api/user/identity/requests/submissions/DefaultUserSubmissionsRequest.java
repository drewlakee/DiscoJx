package discojx.discogs.api.user.identity.requests.submissions;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.requests.Submissions;
import discojx.requests.AbstractPathParameterizedRequestBuilder;
import discojx.requests.AbstractRequest;
import discojx.utils.json.JsonUtils;
import discojx.utils.requests.RequestPathParametersConstructor;
import discojx.utils.requests.StringBuilderSequentialRequestPathParametersConstructor;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultUserSubmissionsRequest extends AbstractRequest
        implements UserSubmissionsRequest {

    public DefaultUserSubmissionsRequest(Builder builder) {
        super(builder);
    }

    public static class Builder extends AbstractPathParameterizedRequestBuilder<RequestPathParametersConstructor>
            implements UserSubmissionsRequestBuilder {

        private String username;
        private int page;
        private int perPage;

        public Builder(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public UserSubmissionsRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        @Override
        public UserSubmissionsRequestBuilder page(int page) {
            this.page = page;
            return this;
        }

        @Override
        public UserSubmissionsRequestBuilder perPage(int perPage) {
            this.perPage = perPage;
            return this;
        }

        @Override
        public UserSubmissionsRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .USER_SUBMISSIONS
                    .getEndpointWith(constructPathParameters().toParametersString())
                    .replace("{username}", username);
            return new DefaultUserSubmissionsRequest(this);
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
                    "client=" + client +
                    ", username='" + username + '\'' +
                    ", page=" + page +
                    ", perPage=" + perPage +
                    ", endpointParameters='" + queryUrl + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return page == builder.page && perPage == builder.perPage && Objects.equals(client, builder.client) && Objects.equals(username, builder.username) && Objects.equals(queryUrl, builder.queryUrl);
        }

        @Override
        public int hashCode() {
            return Objects.hash(client, username, page, perPage, queryUrl);
        }
    }

    @Override
    public CompletableFuture<Submissions> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            HttpResponse response = client.execute(new HttpGet(queryUrl));

            Submissions submissions;
            try {
                submissions = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(response.getEntity().getContent(), Submissions.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return submissions;
        });
    }
}
