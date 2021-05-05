package discojx.discogs.objects.models;

import java.util.List;
import java.util.Objects;

public class Format {

    private String name;
    private String qty;
    private List<String> descriptions;
    private String text;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public List<String> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<String> descriptions) {
        this.descriptions = descriptions;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Format{" +
                "name='" + name + '\'' +
                ", qty='" + qty + '\'' +
                ", descriptions=" + descriptions +
                ", text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Format format = (Format) o;
        return Objects.equals(name, format.name) && Objects.equals(qty, format.qty) && Objects.equals(descriptions, format.descriptions) && Objects.equals(text, format.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, qty, descriptions, text);
    }
}
