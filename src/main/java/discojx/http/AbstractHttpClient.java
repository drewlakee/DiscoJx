package discojx.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;

public abstract class AbstractHttpClient {

    public abstract HttpResponse execute(HttpUriRequest request);
}
