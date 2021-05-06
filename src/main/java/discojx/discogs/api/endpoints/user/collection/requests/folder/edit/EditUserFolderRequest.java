package discojx.discogs.api.endpoints.user.collection.requests.folder.edit;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.UserFolders;

public interface EditUserFolderRequest extends AsyncExecutableRequest<EntityResponseWrapper<UserFolders.UserFolder>> {
}