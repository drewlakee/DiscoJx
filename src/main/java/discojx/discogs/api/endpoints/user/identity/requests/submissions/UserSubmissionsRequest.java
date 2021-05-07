package discojx.discogs.api.endpoints.user.identity.requests.submissions;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.requests.Submissions;

public interface UserSubmissionsRequest extends AsyncExecutableRequest<EntityResponseWrapper<Submissions>> {
}
