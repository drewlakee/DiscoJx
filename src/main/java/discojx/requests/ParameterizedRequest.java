package discojx.requests;

public interface ParameterizedRequest<T> {

    T constructParameters();
}
