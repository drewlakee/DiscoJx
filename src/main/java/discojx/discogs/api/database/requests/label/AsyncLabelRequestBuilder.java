package discojx.discogs.api.database.requests.label;

public interface AsyncLabelRequestBuilder {

    AsyncLabelRequestBuilder labelId(long labelId);

    AsyncLabelRequest build();
}
