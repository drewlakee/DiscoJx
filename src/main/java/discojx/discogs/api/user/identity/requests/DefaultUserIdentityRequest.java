package discojx.discogs.api.user.identity.requests;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.models.UserIdentity;
import discojx.utils.json.JsonUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultUserIdentityRequest implements UserIdentityRequest {

    protected final AbstractHttpClient client;

    public DefaultUserIdentityRequest(AbstractHttpClient client) {
        this.client = client;
    }

    @Override
    public CompletableFuture<UserIdentity> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            HttpResponse response = client.execute(new HttpGet(DiscogsApiEndpoints.USER_IDENTITY.getEndpoint()));

            UserIdentity userIdentity;
            try {
                userIdentity = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(response.getEntity().getContent(), UserIdentity.class);
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
