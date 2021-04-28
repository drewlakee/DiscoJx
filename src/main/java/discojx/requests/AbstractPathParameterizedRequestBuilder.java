package discojx.requests;

import discojx.clients.AbstractHttpClient;
import discojx.utils.requests.RequestPathParametersConstructor;
import discojx.utils.requests.StringBuilderSequentialRequestPathParametersConstructor;

public abstract class AbstractPathParameterizedRequestBuilder<T, P extends RequestPathParametersConstructor> extends AbstractRequestBuilder<T> {

    public AbstractPathParameterizedRequestBuilder(AbstractHttpClient<T> client) {
        super(client);
    }

    public P constructPathParameters() {
        return (P) new StringBuilderSequentialRequestPathParametersConstructor();
    }
}
