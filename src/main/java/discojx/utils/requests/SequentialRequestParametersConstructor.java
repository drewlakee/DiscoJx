package discojx.utils.requests;

public interface SequentialRequestParametersConstructor extends RequestParametersConstructor {

    SequentialRequestParametersConstructor append(String key, Object value);
}
