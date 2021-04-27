package discojx.discogs.api.database.requests.label;

import discojx.requests.RequestBuilder;

public interface LabelRequestBuilder extends RequestBuilder<LabelRequest> {

    LabelRequestBuilder labelId(long labelId);
}
