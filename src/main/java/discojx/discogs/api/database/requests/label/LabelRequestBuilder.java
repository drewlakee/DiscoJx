package discojx.discogs.api.database.requests.label;

public interface LabelRequestBuilder {

    LabelRequestBuilder labelId(long labelId);

    LabelRequest build();
}
