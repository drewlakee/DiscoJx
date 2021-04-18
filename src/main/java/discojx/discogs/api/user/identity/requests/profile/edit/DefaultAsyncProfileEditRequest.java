package discojx.discogs.api.user.identity.requests.profile.edit;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsEndpoints;
import discojx.discogs.objects.MarketplaceCurrencies;
import discojx.discogs.objects.Profile;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultAsyncProfileEditRequest implements AsyncProfileEditRequest {

    protected final AbstractHttpClient<HttpEntity> client;

    protected static final ObjectMapper jsonMapper = new JsonMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private final String username;
    private final String name;
    private final String homePage;
    private final String location;
    private final String profile;
    private final MarketplaceCurrencies currAbbr;

    private final ObjectNode jsonBody;

    public DefaultAsyncProfileEditRequest(Builder builder) {
        this.client = builder.client;
        this.username = builder.username;
        this.name = builder.name;
        this.homePage = builder.homePage;
        this.location = builder.location;
        this.profile = builder.profile;
        this.currAbbr = builder.currAbbr;
        this.jsonBody = builder.jsonBody;
    }

    public static class Builder implements AsyncProfileEditRequestBuilder {

        private final AbstractHttpClient<HttpEntity> client;

        private String username;
        private String name;
        private String homePage;
        private String location;
        private String profile;
        private MarketplaceCurrencies currAbbr;

        private ObjectNode jsonBody;

        public Builder(AbstractHttpClient<HttpEntity> client) {
            this.client = client;
        }

        @Override
        public AsyncProfileEditRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        @Override
        public AsyncProfileEditRequestBuilder name(String name) {
            this.name = name;
            return this;
        }

        @Override
        public AsyncProfileEditRequestBuilder homePage(String homePage) {
            this.homePage = homePage;
            return this;
        }

        @Override
        public AsyncProfileEditRequestBuilder location(String location) {
            this.location = location;
            return this;
        }

        @Override
        public AsyncProfileEditRequestBuilder profile(String profile) {
            this.profile = profile;
            return this;
        }

        @Override
        public AsyncProfileEditRequestBuilder currAbbr(MarketplaceCurrencies currAbbr) {
            this.currAbbr = currAbbr;
            return this;
        }

        @Override
        public AsyncProfileEditRequest build() {
            this.jsonBody = constructJsonBody();
            return new DefaultAsyncProfileEditRequest(this);
        }

        private ObjectNode constructJsonBody() {
            ObjectNode jsonObject = JsonNodeFactory.instance.objectNode();

            if (name != null) jsonObject.put("name", name);
            if (homePage != null) jsonObject.put("home_page", homePage);
            if (location != null) jsonObject.put("location", location);
            if (profile != null) jsonObject.put("profile", profile);
            if (currAbbr != null) jsonObject.put("curr_abbr", currAbbr.name());

            return jsonObject;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return Objects.equals(client, builder.client) && Objects.equals(username, builder.username) && Objects.equals(name, builder.name) && Objects.equals(homePage, builder.homePage) && Objects.equals(location, builder.location) && Objects.equals(profile, builder.profile) && currAbbr == builder.currAbbr && Objects.equals(jsonBody, builder.jsonBody);
        }

        @Override
        public int hashCode() {
            return Objects.hash(client, username, name, homePage, location, profile, currAbbr, jsonBody);
        }
    }

    @Override
    public CompletableFuture<Profile> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            HttpPost request = new HttpPost(DiscogsEndpoints.USER_PROFILE_EDIT.getEndpoint().replace("{username}", username));
            request.addHeader("Content-Type", "application/json");
            request.setEntity(new StringEntity(jsonBody.toString(), "UTF-8"));
            Optional<HttpEntity> execute = client.execute(request);
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            Profile profile;
            try {
                profile = jsonMapper.readValue(httpEntity.getContent(), Profile.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return profile;
        });
    }

    @Override
    public String toString() {
        return "DefaultAsyncProfileEditRequest{" +
                "client=" + client +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", homePage='" + homePage + '\'' +
                ", location='" + location + '\'' +
                ", profile='" + profile + '\'' +
                ", currAbbr=" + currAbbr +
                ", jsonBody=" + jsonBody +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultAsyncProfileEditRequest that = (DefaultAsyncProfileEditRequest) o;
        return Objects.equals(client, that.client) && Objects.equals(username, that.username) && Objects.equals(name, that.name) && Objects.equals(homePage, that.homePage) && Objects.equals(location, that.location) && Objects.equals(profile, that.profile) && currAbbr == that.currAbbr && Objects.equals(jsonBody, that.jsonBody);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, username, name, homePage, location, profile, currAbbr, jsonBody);
    }
}
