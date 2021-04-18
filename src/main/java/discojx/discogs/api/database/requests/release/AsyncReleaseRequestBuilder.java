package discojx.discogs.api.database.requests.release;

import discojx.discogs.objects.MarketplaceCurrencies;

public interface AsyncReleaseRequestBuilder {

    AsyncReleaseRequestBuilder releaseId(long id);
    AsyncReleaseRequestBuilder currAbbr(MarketplaceCurrencies currency);

    AsyncReleaseRequest build();
}
