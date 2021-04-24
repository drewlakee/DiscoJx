package discojx.requests;

public interface PathParameterizedRequest<T> {

    T constructPathParameters();
}
