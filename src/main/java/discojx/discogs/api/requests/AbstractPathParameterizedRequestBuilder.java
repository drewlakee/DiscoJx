package discojx.discogs.api.requests;

import discojx.clients.AbstractHttpClient;
import discojx.utils.requests.RequestPathParametersConstructor;
import discojx.utils.requests.StringBuilderSequentialRequestPathParametersConstructor;

public abstract class AbstractPathParameterizedRequestBuilder<P extends RequestPathParametersConstructor> extends AbstractRequestBuilder {

    public AbstractPathParameterizedRequestBuilder(AbstractHttpClient client) {
        super(client);
    }

    public P constructPathParameters() {
        return (P) new StringBuilderSequentialRequestPathParametersConstructor();
    }
}
