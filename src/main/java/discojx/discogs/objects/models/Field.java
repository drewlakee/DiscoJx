package discojx.discogs.objects.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class Field {

    private long id;
    private String name;
    private String type;
    private int position;
    @JsonProperty("public")
    private boolean isPublic;
    private List<String> options;
    private int lines;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    @Override
    public String toString() {
        return "Field{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", position=" + position +
                ", isPublic=" + isPublic +
                ", options=" + options +
                ", lines=" + lines +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return id == field.id && position == field.position && isPublic == field.isPublic && lines == field.lines && Objects.equals(name, field.name) && Objects.equals(type, field.type) && Objects.equals(options, field.options);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, position, isPublic, options, lines);
    }
}
