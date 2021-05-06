package discojx.discogs.api.endpoints.user.wantlist.requests.add;

import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.UserWant;
import discojx.discogs.api.requests.AsyncExecutableRequest;

public interface AddUserWantListRequest extends AsyncExecutableRequest<EntityResponseWrapper<UserWant>> {
}
