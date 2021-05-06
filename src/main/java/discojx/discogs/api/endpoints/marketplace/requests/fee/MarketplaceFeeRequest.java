package discojx.discogs.api.endpoints.marketplace.requests.fee;

import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.Fee;
import discojx.discogs.api.requests.AsyncExecutableRequest;

public interface MarketplaceFeeRequest extends AsyncExecutableRequest<EntityResponseWrapper<Fee>> {
}
