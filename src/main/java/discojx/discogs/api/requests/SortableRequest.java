package discojx.discogs.api.requests;

public interface SortableRequest<T> {

    T sort(String attribute);
    T sortOrder(String sortOrder);
}
