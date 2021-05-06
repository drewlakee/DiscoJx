package discojx.discogs.api.endpoints.marketplace.listing.requests.create;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.CreatedListingInfo;

public interface MarketplaceNewListingRequest extends AsyncExecutableRequest<EntityResponseWrapper<CreatedListingInfo>> {
}
