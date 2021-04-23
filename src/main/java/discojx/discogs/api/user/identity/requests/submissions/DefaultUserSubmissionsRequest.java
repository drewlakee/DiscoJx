package discojx.discogs.api.user.identity.requests.submissions;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsEndpoints;
import discojx.discogs.objects.Submissions;
import discojx.utils.requests.RequestParametersConstructor;
import discojx.utils.requests.StringBuilderSequentialRequestParametersConstructor;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultUserSubmissionsRequest implements UserSubmissionsRequest {

    protected final AbstractHttpClient<HttpEntity> client;

    protected static final ObjectMapper jsonMapper = new JsonMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private final String username;

    private final String queryUrl;

    public DefaultUserSubmissionsRequest(Builder builder) {
        this.client = builder.client;
        this.username = builder.username;
        this.queryUrl = builder.queryUrl;
    }

    public static class Builder implements UserSubmissionsRequestBuilder {

        private final AbstractHttpClient<HttpEntity> client;

        private String username;
        private int page;
        private int perPage;

        private String queryUrl;

        public Builder(AbstractHttpClient<HttpEntity> client) {
            this.client = client;
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
            this.queryUrl = DiscogsEndpoints.USER_SUBMISSIONS.getEndpointWith(constructParameters().toParametersString());
            return new DefaultUserSubmissionsRequest(this);
        }

        @Override
        public RequestParametersConstructor constructParameters() {
            StringBuilderSequentialRequestParametersConstructor parameters =
                    new StringBuilderSequentialRequestParametersConstructor();

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
    public CompletableFuture<Submissions> supplyFuture() {
        return CompletableFuture.supplyAsync(() -> {
            Optional<HttpEntity> execute = client.execute(new HttpGet(queryUrl.replace("{username}", username)));
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            Submissions submissions;
            try {
                submissions = jsonMapper.readValue(httpEntity.getContent(), Submissions.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return submissions;
        });
    }

    @Override
    public String toString() {
        return "DefaultUserSubmissionsRequest{" +
                "client=" + client +
                ", username='" + username + '\'' +
                ", endpointParameters='" + queryUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultUserSubmissionsRequest that = (DefaultUserSubmissionsRequest) o;
        return Objects.equals(client, that.client) && Objects.equals(username, that.username) && Objects.equals(queryUrl, that.queryUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, username, queryUrl);
    }
}
