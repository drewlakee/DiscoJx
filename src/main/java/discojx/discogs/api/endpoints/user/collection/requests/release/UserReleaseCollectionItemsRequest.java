package discojx.discogs.api.endpoints.user.collection.requests.release;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.UserReleaseCollectionItems;

public interface UserReleaseCollectionItemsRequest extends AsyncExecutableRequest<EntityResponseWrapper<UserReleaseCollectionItems>> {
}
