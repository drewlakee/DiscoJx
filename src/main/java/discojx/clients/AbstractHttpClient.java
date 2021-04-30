package discojx.clients;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;

import java.util.Optional;

public abstract class AbstractHttpClient {

    public abstract HttpResponse execute(HttpUriRequest request);
}
