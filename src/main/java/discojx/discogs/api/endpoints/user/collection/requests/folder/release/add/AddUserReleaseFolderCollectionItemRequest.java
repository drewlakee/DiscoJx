package discojx.discogs.api.endpoints.user.collection.requests.folder.release.add;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.UserReleaseCollectionItems;

public interface AddUserReleaseFolderCollectionItemRequest extends AsyncExecutableRequest<EntityResponseWrapper<UserReleaseCollectionItems.Release.Short>> {
}
