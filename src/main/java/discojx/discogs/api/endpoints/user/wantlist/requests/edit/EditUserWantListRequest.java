package discojx.discogs.api.endpoints.user.wantlist.requests.edit;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.UserWant;

public interface EditUserWantListRequest extends AsyncExecutableRequest<EntityResponseWrapper<UserWant>> {
}
