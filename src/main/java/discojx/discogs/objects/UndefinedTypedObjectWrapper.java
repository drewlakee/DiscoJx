package discojx.discogs.objects;

import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Objects;

public class UndefinedTypedObjectWrapper extends AbstractTypedObject {

    protected ObjectNode undefinedJsonObject;

    public UndefinedTypedObjectWrapper(ObjectNode undefinedJsonObject) {
        this.setType(undefinedJsonObject.get("type").isEmpty() ? "undefined" : undefinedJsonObject.get("type").asText());
        this.undefinedJsonObject = undefinedJsonObject;
    }

    public ObjectNode getUndefinedJsonObject() {
        return undefinedJsonObject;
    }

    public void setUndefinedJsonObject(ObjectNode undefinedJsonObject) {
        this.undefinedJsonObject = undefinedJsonObject;
    }

    @Override
    public String toString() {
        return "UndefinedTypedObjectWrapper{" +
                "undefinedJsonObject=" + undefinedJsonObject +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UndefinedTypedObjectWrapper that = (UndefinedTypedObjectWrapper) o;
        return Objects.equals(undefinedJsonObject, that.undefinedJsonObject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), undefinedJsonObject);
    }
}