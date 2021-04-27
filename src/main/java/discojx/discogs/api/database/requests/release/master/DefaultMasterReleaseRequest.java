package discojx.discogs.api.database.requests.release.master;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.MasterRelease;
import discojx.requests.AbstractRequest;
import discojx.requests.AbstractRequestBuilder;
import discojx.utils.json.JsonUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultMasterReleaseRequest extends AbstractRequest<HttpEntity>
        implements MasterReleaseRequest {

    public DefaultMasterReleaseRequest(Builder builder) {
        super(builder);
    }

    public static class Builder extends AbstractRequestBuilder<HttpEntity>
            implements MasterReleaseRequestBuilder {

        private long masterId;

        public Builder(AbstractHttpClient<HttpEntity> client) {
            super(client);
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
}
