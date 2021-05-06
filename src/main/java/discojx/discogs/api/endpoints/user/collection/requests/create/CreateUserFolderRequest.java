package discojx.discogs.api.endpoints.user.collection.requests.create;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.UserFolders;

public interface CreateUserFolderRequest extends AsyncExecutableRequest<EntityResponseWrapper<UserFolders.UserFolder>> {
}
