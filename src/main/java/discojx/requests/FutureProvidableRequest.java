package discojx.requests;

import java.util.concurrent.CompletableFuture;

public interface FutureProvidableRequest<T> {

    CompletableFuture<T> supplyFuture();
}
