package discojx.discogs.api.endpoints.user.wantlist.requests.add;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.UserWant;

public interface AddUserWantListRequest extends AsyncExecutableRequest<EntityResponseWrapper<UserWant>> {
}
