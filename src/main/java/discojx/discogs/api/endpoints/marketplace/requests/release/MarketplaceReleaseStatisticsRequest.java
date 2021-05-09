package discojx.discogs.api.endpoints.marketplace.requests.release;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface MarketplaceReleaseStatisticsRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
