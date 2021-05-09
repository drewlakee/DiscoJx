package discojx.discogs.api.endpoints.marketplace.listing.requests.create;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface MarketplaceNewListingRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
