package discojx.discogs.api.database.requests.release;

import discojx.discogs.objects.MarketplaceCurrencies;
import discojx.requests.RequestBuilder;

public interface ReleaseRequestBuilder extends RequestBuilder<ReleaseRequest> {

    ReleaseRequestBuilder releaseId(long id);
    ReleaseRequestBuilder currAbbr(MarketplaceCurrencies currency);
}
