package discojx.discogs.api.endpoints.database.requests.label;

import discojx.discogs.api.requests.RequestBuilder;

public interface LabelRequestBuilder extends RequestBuilder<LabelRequest> {

    LabelRequestBuilder labelId(long labelId);
}
