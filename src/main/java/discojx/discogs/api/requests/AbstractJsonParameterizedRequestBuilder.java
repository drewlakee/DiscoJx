package discojx.discogs.api.requests;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.http.AbstractHttpClient;

import java.util.Objects;

public abstract class AbstractJsonParameterizedRequestBuilder<J extends JsonNode> extends AbstractRequestBuilder {

    protected J jsonObject;

    public AbstractJsonParameterizedRequestBuilder(AbstractHttpClient client) {
        super(client);
    }

    protected abstract J constructJsonParameters();

    @Override
    public String toString() {
        return "AbstractJsonParameterizedRequestBuilder{" +
                "jsonObject=" + jsonObject +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AbstractJsonParameterizedRequestBuilder<?> that = (AbstractJsonParameterizedRequestBuilder<?>) o;
        return Objects.equals(jsonObject, that.jsonObject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), jsonObject);
    }
}
