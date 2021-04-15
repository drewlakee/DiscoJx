package discojx.clients;

import org.apache.http.client.methods.HttpUriRequest;

import java.util.Optional;

public abstract class AbstractHttpClient<T> {

    public abstract Optional<T> execute(HttpUriRequest request);
}
