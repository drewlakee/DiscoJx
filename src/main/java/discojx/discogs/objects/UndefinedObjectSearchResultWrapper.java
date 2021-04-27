package discojx.discogs.objects;

import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Objects;

public class UndefinedObjectSearchResultWrapper extends AbstractTypedSearchResult {

    private ObjectNode undefinedJsonObject;

    public UndefinedObjectSearchResultWrapper(ObjectNode undefinedJsonObject) {
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
        return "UndefinedObjectSearchResultWrapper{" +
                "undefinedJsonObject=" + undefinedJsonObject +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UndefinedObjectSearchResultWrapper that = (UndefinedObjectSearchResultWrapper) o;
        return Objects.equals(undefinedJsonObject, that.undefinedJsonObject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), undefinedJsonObject);
    }
}
