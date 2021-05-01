package discojx.discogs.api.database.requests.release;

import discojx.discogs.objects.MarketplaceCurrency;
import discojx.requests.RequestBuilder;

public interface ReleaseRequestBuilder extends RequestBuilder<ReleaseRequest> {

    ReleaseRequestBuilder releaseId(long id);
    ReleaseRequestBuilder currAbbr(MarketplaceCurrency currency);
}
