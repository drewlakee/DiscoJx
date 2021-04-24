package discojx.discogs.api.database.requests.label;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.Label;
import discojx.utils.json.JsonUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultLabelRequest implements LabelRequest {

    protected final AbstractHttpClient<HttpEntity> client;

    private final long labelId;

    public DefaultLabelRequest(Builder builder) {
        this.client = builder.client;
        this.labelId = builder.labelId;
    }

    public static class Builder implements LabelRequestBuilder {

        private final AbstractHttpClient<HttpEntity> client;

        private long labelId;

        public Builder(AbstractHttpClient<HttpEntity> client) {
            this.client = client;
        }

        @Override
        public LabelRequestBuilder labelId(long labelId) {
            this.labelId = labelId;
            return this;
        }

        @Override
        public LabelRequest build() {
            return new DefaultLabelRequest(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "client=" + client +
                    ", labelId=" + labelId +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return labelId == builder.labelId && Objects.equals(client, builder.client);
        }

        @Override
        public int hashCode() {
            return Objects.hash(client, labelId);
        }
    }

    @Override
    public CompletableFuture<Label> supplyFuture() {
        return CompletableFuture.supplyAsync(() -> {
            Optional<HttpEntity> execute = client.execute(new HttpGet(DiscogsApiEndpoints.DATABASE_LABEL.getEndpoint().replace("{label_id}", String.valueOf(labelId))));
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            Label label;
            try {
                label = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(httpEntity.getContent(), Label.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return label;
        });
    }

    @Override
    public String toString() {
        return "DefaultLabelRequest{" +
                "client=" + client +
                ", labelId=" + labelId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultLabelRequest that = (DefaultLabelRequest) o;
        return labelId == that.labelId && Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, labelId);
    }
}
