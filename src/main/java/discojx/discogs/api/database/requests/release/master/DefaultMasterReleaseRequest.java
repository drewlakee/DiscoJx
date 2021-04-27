package discojx.discogs.api.database.requests.release.master;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.MasterRelease;
import discojx.utils.json.JsonUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultMasterReleaseRequest implements MasterReleaseRequest {

    protected final AbstractHttpClient<HttpEntity> client;

    private final String queryUrl;

    public DefaultMasterReleaseRequest(Builder builder) {
        this.client = builder.client;
        this.queryUrl = builder.queryUrl;
    }

    public static class Builder implements MasterReleaseRequestBuilder {

        private final AbstractHttpClient<HttpEntity> client;

        private long masterId;

        private String queryUrl;

        public Builder(AbstractHttpClient<HttpEntity> client) {
            this.client = client;
        }

        @Override
        public MasterReleaseRequestBuilder masterId(long masterId) {
            this.masterId = masterId;
            return this;
        }

        @Override
        public MasterReleaseRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .DATABASE_MASTER_RELEASE
                    .getEndpoint()
                    .replace("{master_id}", String.valueOf(masterId));
            return new DefaultMasterReleaseRequest(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "client=" + client +
                    ", masterId=" + masterId +
                    ", queryUrl='" + queryUrl + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return masterId == builder.masterId && Objects.equals(client, builder.client) && Objects.equals(queryUrl, builder.queryUrl);
        }

        @Override
        public int hashCode() {
            return Objects.hash(client, masterId, queryUrl);
        }
    }

    @Override
    public CompletableFuture<MasterRelease> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            Optional<HttpEntity> execute = client.execute(new HttpGet(queryUrl));
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            MasterRelease masterRelease;
            try {
                masterRelease = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(httpEntity.getContent(), MasterRelease.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return masterRelease;
        });
    }

    @Override
    public String toString() {
        return "DefaultMasterReleaseRequest{" +
                "client=" + client +
                ", queryUrl='" + queryUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultMasterReleaseRequest that = (DefaultMasterReleaseRequest) o;
        return Objects.equals(client, that.client) && Objects.equals(queryUrl, that.queryUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, queryUrl);
    }
}
