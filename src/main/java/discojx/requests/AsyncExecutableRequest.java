package discojx.requests;

import java.util.concurrent.CompletableFuture;

public interface AsyncExecutableRequest<T> {

    CompletableFuture<T> executeAsync();
}
