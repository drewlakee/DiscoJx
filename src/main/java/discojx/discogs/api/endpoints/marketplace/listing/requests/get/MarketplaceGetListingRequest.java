package discojx.discogs.api.endpoints.marketplace.listing.requests.get;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.Listing;

public interface MarketplaceGetListingRequest extends AsyncExecutableRequest<EntityResponseWrapper<Listing>> {
}
