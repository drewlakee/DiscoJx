package discojx.discogs.api.endpoints.user.collection.requests;

import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.UserFolders;
import discojx.discogs.api.requests.AsyncExecutableRequest;

public interface UserFoldersRequest extends AsyncExecutableRequest<EntityResponseWrapper<UserFolders>> {
}
