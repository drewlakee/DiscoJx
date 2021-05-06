package discojx.discogs.api.endpoints.marketplace.requests.fee.currency;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.Fee;

public interface MarketplaceFeeWithCurrencyRequest extends AsyncExecutableRequest<EntityResponseWrapper<Fee>> {
}
