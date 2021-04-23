package discojx.discogs.api.user.identity.requests;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsEndpoints;
import discojx.discogs.objects.UserIdentity;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultUserIdentityRequest implements UserIdentityRequest {

    protected final AbstractHttpClient<HttpEntity> client;

    protected static final ObjectMapper jsonMapper = new JsonMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public DefaultUserIdentityRequest(AbstractHttpClient<HttpEntity> client) {
        this.client = client;
    }

    @Override
    public CompletableFuture<UserIdentity> supplyFuture() {
        return CompletableFuture.supplyAsync(() -> {
            Optional<HttpEntity> execute = client.execute(new HttpGet(DiscogsEndpoints.USER_IDENTITY.getEndpoint()));
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            UserIdentity userIdentity;
            try {
                userIdentity = jsonMapper.readValue(httpEntity.getContent(), UserIdentity.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return userIdentity;
        });
    }

    @Override
    public String toString() {
        return "DefaultUserIdentityRequest{" +
                "client=" + client +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultUserIdentityRequest that = (DefaultUserIdentityRequest) o;
        return Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client);
    }
}
