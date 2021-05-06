package discojx.discogs.api.endpoints.user.collection.requests.folder.release;

import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.UserReleaseCollectionItems;
import discojx.discogs.api.requests.AsyncExecutableRequest;

public interface UserReleaseFolderCollectionItemsRequest extends AsyncExecutableRequest<EntityResponseWrapper<UserReleaseCollectionItems>> {
}
