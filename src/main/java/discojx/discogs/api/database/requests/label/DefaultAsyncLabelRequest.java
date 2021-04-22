package discojx.discogs.api.database.requests.label;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsEndpoints;
import discojx.discogs.objects.Artist;
import discojx.discogs.objects.Label;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultAsyncLabelRequest implements AsyncLabelRequest {

    protected final AbstractHttpClient<HttpEntity> client;

    protected static final ObjectMapper jsonMapper = new JsonMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private final long labelId;

    public DefaultAsyncLabelRequest(Builder builder) {
        this.client = builder.client;
        this.labelId = builder.labelId;
    }

    public static class Builder implements AsyncLabelRequestBuilder {

        private final AbstractHttpClient<HttpEntity> client;

        private long labelId;

        public Builder(AbstractHttpClient<HttpEntity> client) {
            this.client = client;
        }

        @Override
        public AsyncLabelRequestBuilder labelId(long labelId) {
            this.labelId = labelId;
            return this;
        }

        @Override
        public AsyncLabelRequest build() {
            return new DefaultAsyncLabelRequest(this);
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
    public CompletableFuture<Label> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            Optional<HttpEntity> execute = client.execute(new HttpGet(DiscogsEndpoints.DATABASE_LABEL.getEndpoint().replace("{label_id}", String.valueOf(labelId))));
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            Label label;
            try {
                label = jsonMapper.readValue(httpEntity.getContent(), Label.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return label;
        });
    }

    @Override
    public String toString() {
        return "DefaultAsyncLabelRequest{" +
                "client=" + client +
                ", labelId=" + labelId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultAsyncLabelRequest that = (DefaultAsyncLabelRequest) o;
        return labelId == that.labelId && Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, labelId);
    }
}
