package discojx.discogs.api.endpoints.user.collection.requests;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.UserFolders;

public interface UserFoldersRequest extends AsyncExecutableRequest<EntityResponseWrapper<UserFolders>> {
}