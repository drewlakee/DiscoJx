package discojx.discogs.api.endpoints.user.lists.requests.list;

import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.UserList;
import discojx.discogs.api.requests.AsyncExecutableRequest;

public interface UserListRequest extends AsyncExecutableRequest<EntityResponseWrapper<UserList>> {
}
