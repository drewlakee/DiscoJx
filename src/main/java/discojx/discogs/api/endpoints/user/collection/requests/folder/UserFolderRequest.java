package discojx.discogs.api.endpoints.user.collection.requests.folder;

import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.UserFolders;
import discojx.discogs.api.requests.AsyncExecutableRequest;

public interface UserFolderRequest extends AsyncExecutableRequest<EntityResponseWrapper<UserFolders.UserFolder>> {
}
