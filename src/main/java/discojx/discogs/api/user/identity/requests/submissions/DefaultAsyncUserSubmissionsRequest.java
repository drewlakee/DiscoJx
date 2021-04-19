package discojx.discogs.api.user.identity.requests.submissions;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsEndpoints;
import discojx.discogs.objects.Submissions;
import discojx.requests.ParameterizedRequest;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultAsyncUserSubmissionsRequest implements AsyncUserSubmissionsRequest {

    protected final AbstractHttpClient<HttpEntity> client;

    protected static final ObjectMapper jsonMapper = new JsonMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private final String username;

    private final String endpointParameters;

    public DefaultAsyncUserSubmissionsRequest(Builder builder) {
        this.client = builder.client;
        this.username = builder.username;
        this.endpointParameters = builder.endpointParameters;
    }

    public static class Builder implements AsyncUserSubmissionsRequestBuilder, ParameterizedRequest<String> {

        private final AbstractHttpClient<HttpEntity> client;

        private String username;
        private int page;
        private int perPage;

        private String endpointParameters;

        public Builder(AbstractHttpClient<HttpEntity> client) {
            this.client = client;
        }

        @Override
        public AsyncUserSubmissionsRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        @Override
        public AsyncUserSubmissionsRequestBuilder page(int page) {
            this.page = page;
            return this;
        }

        @Override
        public AsyncUserSubmissionsRequestBuilder perPage(int perPage) {
            this.perPage = perPage;
            return this;
        }

        @Override
        public AsyncUserSubmissionsRequest build() {
            this.endpointParameters = constructParameters();
            return new DefaultAsyncUserSubmissionsRequest(this);
        }

        @Override
        public String constructParameters() {
            ArrayList<String> parameters = new ArrayList<>();

            if (page > 0) parameters.add("page=" + page);
            if (perPage > 0) parameters.add("per_page=" + perPage);

            if (parameters.size() > 0) {
                return "?" + String.join("&", parameters);
            } else {
                return "";
            }
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "client=" + client +
                    ", username='" + username + '\'' +
                    ", page=" + page +
                    ", perPage=" + perPage +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return page == builder.page && perPage == builder.perPage && Objects.equals(client, builder.client) && Objects.equals(username, builder.username);
        }

        @Override
        public int hashCode() {
            return Objects.hash(client, username, page, perPage);
        }
    }

    @Override
    public CompletableFuture<Submissions> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            Optional<HttpEntity> execute = client.execute(new HttpGet(DiscogsEndpoints.USER_SUBMISSIONS.getEndpoint().replace("{username}", username) + endpointParameters));
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
        return "DefaultAsyncUserSubmissionsRequest{" +
                "client=" + client +
                ", username='" + username + '\'' +
                ", endpointParameters='" + endpointParameters + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultAsyncUserSubmissionsRequest that = (DefaultAsyncUserSubmissionsRequest) o;
        return Objects.equals(client, that.client) && Objects.equals(username, that.username) && Objects.equals(endpointParameters, that.endpointParameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, username, endpointParameters);
    }
}
