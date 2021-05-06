package discojx.discogs.api.endpoints.user.lists.requests.list;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.UserList;

public interface UserListRequest extends AsyncExecutableRequest<EntityResponseWrapper<UserList>> {
}
