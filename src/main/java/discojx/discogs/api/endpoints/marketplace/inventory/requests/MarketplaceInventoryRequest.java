package discojx.discogs.api.endpoints.marketplace.inventory.requests;

import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.requests.MarketplaceInventory;
import discojx.discogs.api.requests.AsyncExecutableRequest;

public interface MarketplaceInventoryRequest extends AsyncExecutableRequest<EntityResponseWrapper<MarketplaceInventory>> {
}
