package discojx.discogs.api.endpoints.marketplace.requests.fee;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.Fee;

public interface MarketplaceFeeRequest extends AsyncExecutableRequest<EntityResponseWrapper<Fee>> {
}
