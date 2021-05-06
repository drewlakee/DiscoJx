package discojx.discogs.api.endpoints.user.lists.requests;

import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.UserLists;
import discojx.discogs.api.requests.AsyncExecutableRequest;

public interface UserListsRequest extends AsyncExecutableRequest<EntityResponseWrapper<UserLists>> {
}
