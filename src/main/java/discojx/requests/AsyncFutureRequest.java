package discojx.requests;

import java.util.concurrent.CompletableFuture;

public interface AsyncFutureRequest<T> {

    CompletableFuture<T> supplyFuture();
}
