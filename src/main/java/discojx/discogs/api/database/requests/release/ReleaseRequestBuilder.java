package discojx.discogs.api.database.requests.release;

import discojx.requests.RequestBuilder;

public interface ReleaseRequestBuilder extends RequestBuilder<ReleaseRequest> {

    ReleaseRequestBuilder releaseId(long id);
    ReleaseRequestBuilder currAbbr(String currency);
}
