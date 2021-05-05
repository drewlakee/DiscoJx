package discojx.discogs.objects.models;

import java.util.Objects;

public class Identifier {

    private String type;
    private String value;
    private String description;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Identifier{" +
                "type='" + type + '\'' +
                ", value='" + value + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identifier that = (Identifier) o;
        return Objects.equals(type, that.type) && Objects.equals(value, that.value) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, value, description);
    }
}
