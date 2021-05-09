package discojx.discogs.api.requests;

import discojx.http.AbstractHttpClient;
import discojx.utils.requests.RequestPathParametersConstructor;

public abstract class AbstractPathParameterizedRequestBuilder<P extends RequestPathParametersConstructor> extends AbstractRequestBuilder {

    public AbstractPathParameterizedRequestBuilder(AbstractHttpClient client) {
        super(client);
    }

    protected abstract P constructPathParameters();
}
