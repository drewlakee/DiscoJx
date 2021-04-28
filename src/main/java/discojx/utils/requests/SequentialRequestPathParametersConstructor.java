package discojx.utils.requests;

public interface SequentialRequestPathParametersConstructor extends RequestPathParametersConstructor {

    SequentialRequestPathParametersConstructor append(String key, Object value);
}
