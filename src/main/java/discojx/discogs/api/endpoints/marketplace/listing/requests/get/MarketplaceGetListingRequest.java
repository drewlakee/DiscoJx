package discojx.discogs.api.endpoints.marketplace.listing.requests.get;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface MarketplaceGetListingRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
