package discojx.discogs.api.database.requests.release;

import discojx.discogs.objects.MarketplaceCurrencies;
import discojx.requests.ParameterizedRequest;
import discojx.utils.requests.RequestParametersConstructor;

public interface AsyncReleaseRequestBuilder extends ParameterizedRequest<RequestParametersConstructor> {

    AsyncReleaseRequestBuilder releaseId(long id);
    AsyncReleaseRequestBuilder currAbbr(MarketplaceCurrencies currency);

    AsyncReleaseRequest build();
}
