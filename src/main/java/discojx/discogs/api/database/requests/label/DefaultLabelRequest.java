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

    private final String queryUrl;

    public DefaultLabelRequest(Builder builder) {
        this.client = builder.client;
        this.queryUrl = builder.queryUrl;
    }

    public static class Builder implements LabelRequestBuilder {

        private final AbstractHttpClient<HttpEntity> client;

        private long labelId;

        private String queryUrl;

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
            this.queryUrl = DiscogsApiEndpoints.DATABASE_LABEL.getEndpoint().replace("{label_id}", String.valueOf(labelId));
            return new DefaultLabelRequest(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "client=" + client +
                    ", labelId=" + labelId +
                    ", queryUrl='" + queryUrl + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return labelId == builder.labelId && Objects.equals(client, builder.client) && Objects.equals(queryUrl, builder.queryUrl);
        }

        @Override
        public int hashCode() {
            return Objects.hash(client, labelId, queryUrl);
        }
    }

    @Override
    public CompletableFuture<Label> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            Optional<HttpEntity> execute = client.execute(new HttpGet(queryUrl));
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
                ", queryUrl='" + queryUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultLabelRequest that = (DefaultLabelRequest) o;
        return Objects.equals(client, that.client) && Objects.equals(queryUrl, that.queryUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, queryUrl);
    }
}
