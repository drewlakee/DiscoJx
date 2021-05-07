package discojx.discogs.api.endpoints.user.lists.requests;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.UserLists;

public interface UserListsRequest extends AsyncExecutableRequest<EntityResponseWrapper<UserLists>> {
}
