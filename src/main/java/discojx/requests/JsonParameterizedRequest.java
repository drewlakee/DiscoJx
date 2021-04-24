package discojx.requests;

public interface JsonParameterizedRequest<T> {

    T constructJsonParameters();
}
