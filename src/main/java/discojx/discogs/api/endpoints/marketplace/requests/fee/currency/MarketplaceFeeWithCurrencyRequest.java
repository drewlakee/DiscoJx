package discojx.discogs.api.endpoints.marketplace.requests.fee.currency;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface MarketplaceFeeWithCurrencyRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
