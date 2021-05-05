package discojx.discogs.api.requests;

import java.util.concurrent.CompletableFuture;

public interface AsyncExecutableRequest<T> {

    CompletableFuture<T> executeAsync();
}
