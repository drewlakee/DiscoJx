package discojx.requests;

public interface SortableRequest<T> {

    T sort(String attribute);
    T sortOrder(String sortOrder);
}
