package discojx.discogs.api.user.identity.requests;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import discojx.cleaners.Cleanable;
import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsEndpoints;
import discojx.discogs.objects.UserIdentity;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultCachedAsyncUserIdentityRequest implements AsyncUserIdentityRequest, Cleanable {

    protected final AbstractHttpClient<HttpEntity> client;

    protected static final ObjectMapper jsonMapper = new JsonMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    protected UserIdentity cachedUserIdentity;

    public DefaultCachedAsyncUserIdentityRequest(AbstractHttpClient<HttpEntity> client) {
        this.client = client;
    }

    @Override
    public CompletableFuture<UserIdentity> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            if (cachedUserIdentity != null) {
                return cachedUserIdentity;
            }

            Optional<HttpEntity> execute = client.execute(new HttpGet(DiscogsEndpoints.USER_IDENTITY.getEndpoint()));
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            InputStream jsonResponse;
            try {
                jsonResponse = httpEntity.getContent();
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            UserIdentity userIdentity;
            try {
                userIdentity = jsonMapper.readValue(jsonResponse, UserIdentity.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            cachedUserIdentity = userIdentity;

            return userIdentity;
        });
    }

    @Override
    public void clean() {
        cachedUserIdentity = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultCachedAsyncUserIdentityRequest that = (DefaultCachedAsyncUserIdentityRequest) o;
        return Objects.equals(client, that.client) && Objects.equals(cachedUserIdentity, that.cachedUserIdentity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, cachedUserIdentity);
    }
}
