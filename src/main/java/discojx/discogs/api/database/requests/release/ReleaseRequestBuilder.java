package discojx.discogs.api.database.requests.release;

import discojx.discogs.objects.MarketplaceCurrencies;
import discojx.requests.ParameterizedRequest;
import discojx.utils.requests.RequestParametersConstructor;

public interface ReleaseRequestBuilder extends ParameterizedRequest<RequestParametersConstructor> {

    ReleaseRequestBuilder releaseId(long id);
    ReleaseRequestBuilder currAbbr(MarketplaceCurrencies currency);

    ReleaseRequest build();
}
