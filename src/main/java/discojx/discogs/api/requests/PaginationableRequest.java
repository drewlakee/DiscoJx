package discojx.discogs.api.requests;

public interface PaginationableRequest<T> {

    T page(int page);
    T perPage(int perPage);
}
