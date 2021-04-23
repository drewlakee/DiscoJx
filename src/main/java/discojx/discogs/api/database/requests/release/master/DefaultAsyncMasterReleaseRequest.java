package discojx.discogs.api.database.requests.release.master;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsEndpoints;
import discojx.discogs.objects.MasterRelease;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultAsyncMasterReleaseRequest implements AsyncMasterReleaseRequest {

    protected final AbstractHttpClient<HttpEntity> client;

    protected static final ObjectMapper jsonMapper = new JsonMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private final long masterId;

    public DefaultAsyncMasterReleaseRequest(Builder builder) {
        this.client = builder.client;
        this.masterId = builder.masterId;
    }

    public static class Builder implements AsyncMasterReleaseRequestBuilder {

        private final AbstractHttpClient<HttpEntity> client;

        private long masterId;

        public Builder(AbstractHttpClient<HttpEntity> client) {
            this.client = client;
        }

        @Override
        public AsyncMasterReleaseRequestBuilder masterId(long masterId) {
            this.masterId = masterId;
            return this;
        }

        @Override
        public AsyncMasterReleaseRequest build() {
            return new DefaultAsyncMasterReleaseRequest(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "client=" + client +
                    ", masterId=" + masterId +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return masterId == builder.masterId && Objects.equals(client, builder.client);
        }

        @Override
        public int hashCode() {
            return Objects.hash(client, masterId);
        }
    }

    @Override
    public CompletableFuture<MasterRelease> supplyFuture() {
        return CompletableFuture.supplyAsync(() -> {
            Optional<HttpEntity> execute = client.execute(new HttpGet(DiscogsEndpoints.DATABASE_MASTER_RELEASE.getEndpoint().replace("{master_id}", String.valueOf(masterId))));
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            MasterRelease masterRelease;
            try {
                masterRelease = jsonMapper.readValue(httpEntity.getContent(), MasterRelease.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return masterRelease;
        });
    }

    @Override
    public String toString() {
        return "DefaultAsyncMasterReleaseRequest{" +
                "client=" + client +
                ", masterReleaseId=" + masterId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultAsyncMasterReleaseRequest that = (DefaultAsyncMasterReleaseRequest) o;
        return masterId == that.masterId && Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, masterId);
    }
}
