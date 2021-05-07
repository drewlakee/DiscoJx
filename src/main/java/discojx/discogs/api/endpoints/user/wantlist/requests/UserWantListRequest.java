package discojx.discogs.api.endpoints.user.wantlist.requests;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.requests.UserWantList;

public interface UserWantListRequest extends AsyncExecutableRequest<EntityResponseWrapper<UserWantList>> {
}
