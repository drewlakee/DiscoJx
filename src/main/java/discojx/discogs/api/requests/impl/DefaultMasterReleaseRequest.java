package discojx.discogs.api.requests.impl;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.api.endpoints.database.requests.release.master.MasterReleaseRequest;
import discojx.discogs.api.endpoints.database.requests.release.master.MasterReleaseRequestBuilder;
import discojx.discogs.api.requests.AbstractRequest;
import discojx.discogs.api.requests.AbstractRequestBuilder;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.MasterRelease;
import discojx.utils.json.JsonUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultMasterReleaseRequest extends AbstractRequest
        implements MasterReleaseRequest {

    public DefaultMasterReleaseRequest(Builder builder) {
        super(builder);
    }

    public static class Builder extends AbstractRequestBuilder
            implements MasterReleaseRequestBuilder {

        private long masterId;

        public Builder(AbstractHttpClient client) {
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
    public CompletableFuture<EntityResponseWrapper<MasterRelease>> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            HttpResponse response = client.execute(new HttpGet(queryUrl));

            MasterRelease masterRelease;
            try {
                masterRelease = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(response.getEntity().getContent(), MasterRelease.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return new EntityResponseWrapper<>(response, masterRelease);
        });
    }
}
