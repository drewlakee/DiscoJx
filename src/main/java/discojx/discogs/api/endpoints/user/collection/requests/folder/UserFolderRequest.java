package discojx.discogs.api.endpoints.user.collection.requests.folder;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.UserFolders;

public interface UserFolderRequest extends AsyncExecutableRequest<EntityResponseWrapper<UserFolders.UserFolder>> {
}
