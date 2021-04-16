package discojx.discogs.api.user.identity;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.user.identity.requests.AsyncUserIdentityRequest;
import discojx.discogs.api.user.identity.requests.DefaultAsyncUserIdentityRequest;
import discojx.discogs.api.user.identity.requests.profile.AsyncProfileRequestBuilder;
import discojx.discogs.api.user.identity.requests.profile.DefaultAsyncProfileRequest;
import discojx.discogs.api.user.identity.requests.profile.edit.AsyncProfileEditRequestBuilder;
import discojx.discogs.api.user.identity.requests.profile.edit.DefaultAsyncProfileEditRequest;
import discojx.discogs.api.user.identity.requests.submissions.AsyncUserSubmissionsRequestBuilder;
import discojx.discogs.api.user.identity.requests.submissions.DefaultAsyncUserSubmissionsRequest;
import org.apache.http.HttpEntity;

import java.util.Objects;

public class DefaultAsyncIdentityApi implements AsyncIdentityApi {

    private final AbstractHttpClient<HttpEntity> client;

    public DefaultAsyncIdentityApi(AbstractHttpClient<HttpEntity> client) {
        this.client = client;
    }

    @Override
    public AsyncUserIdentityRequest self() {
        return new DefaultAsyncUserIdentityRequest(client);
    }

    @Override
    public AsyncProfileRequestBuilder profile() {
        return new DefaultAsyncProfileRequest.Builder(client);
    }

    @Override
    public AsyncProfileEditRequestBuilder profileEdit() {
        return new DefaultAsyncProfileEditRequest.Builder(client);
    }

    @Override
    public AsyncUserSubmissionsRequestBuilder submissions() {
        return new DefaultAsyncUserSubmissionsRequest.Builder(client);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultAsyncIdentityApi that = (DefaultAsyncIdentityApi) o;
        return Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client);
    }
}
