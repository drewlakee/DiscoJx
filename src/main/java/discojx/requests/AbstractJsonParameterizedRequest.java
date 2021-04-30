package discojx.requests;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.Objects;

public abstract class AbstractJsonParameterizedRequest<J extends JsonNode> extends AbstractRequest {

    protected final J jsonObject;

    public AbstractJsonParameterizedRequest(AbstractJsonParameterizedRequestBuilder<J> builder) {
        super(builder);
        this.jsonObject = builder.jsonObject;
    }

    @Override
    public String toString() {
        return "AbstractJsonParameterizedRequest{" +
                "jsonObject=" + jsonObject +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AbstractJsonParameterizedRequest<?> that = (AbstractJsonParameterizedRequest<?>) o;
        return Objects.equals(jsonObject, that.jsonObject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), jsonObject);
    }
}
