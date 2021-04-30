package discojx.discogs.api.database.requests.label;

import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.objects.Label;
import discojx.requests.AbstractRequest;
import discojx.requests.AbstractRequestBuilder;
import discojx.utils.json.JsonUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultLabelRequest extends AbstractRequest
        implements LabelRequest {

    public DefaultLabelRequest(Builder builder) {
        super(builder);
    }

    public static class Builder extends AbstractRequestBuilder
            implements LabelRequestBuilder {

        private long labelId;

        public Builder(AbstractHttpClient client) {
            super(client);
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
            HttpResponse response = client.execute(new HttpGet(queryUrl));

            Label label;
            try {
                label = JsonUtils.DefaultObjectMapperHolder.mapper.readValue(response.getEntity().getContent(), Label.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return label;
        });
    }
}
