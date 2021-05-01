package discojx.discogs.objects;

import java.util.List;
import java.util.Objects;

public class GetRecentExports {

    private Pagination pagination;
    private List<ExportItem> items;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<ExportItem> getItems() {
        return items;
    }

    public void setItems(List<ExportItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "GetRecentExports{" +
                "pagination=" + pagination +
                ", items=" + items +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetRecentExports that = (GetRecentExports) o;
        return Objects.equals(pagination, that.pagination) && Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pagination, items);
    }
}
