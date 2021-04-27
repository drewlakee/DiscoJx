package discojx.requests;

import discojx.clients.AbstractHttpClient;
import discojx.utils.requests.RequestParametersConstructor;
import discojx.utils.requests.StringBuilderSequentialRequestParametersConstructor;

public abstract class AbstractPathParameterizedRequestBuilder<T, P extends RequestParametersConstructor> extends AbstractRequestBuilder<T> {

    public AbstractPathParameterizedRequestBuilder(AbstractHttpClient<T> client) {
        super(client);
    }

    public P constructPathParameters() {
        return (P) new StringBuilderSequentialRequestParametersConstructor();
    }
}
