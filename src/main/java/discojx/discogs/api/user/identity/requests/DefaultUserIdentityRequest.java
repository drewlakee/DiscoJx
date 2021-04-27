package discojx.discogs.api.user.identity.requests;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.UserIdentity;
import discojx.utils.json.JsonUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultUserIdentityRequest implements UserIdentityRequest {

    protected final AbstractHttpClient<HttpEntity> client;

    public DefaultUserIdentityRequest(AbstractHttpClient<HttpEntity> client) {
        this.client = client;
    }

    @Override
    public CompletableFuture<UserIdentity> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            Optional<HttpEntity> execute = client.execute(new HttpGet(DiscogsApiEndpoints.USER_IDENTITY.getEndpoint()));
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            UserIdentity userIdentity;
            try {
                userIdentity = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(httpEntity.getContent(), UserIdentity.class);
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
