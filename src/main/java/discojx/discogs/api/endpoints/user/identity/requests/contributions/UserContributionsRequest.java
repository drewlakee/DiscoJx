package discojx.discogs.api.endpoints.user.identity.requests.contributions;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.requests.Contributions;

public interface UserContributionsRequest extends AsyncExecutableRequest<EntityResponseWrapper<Contributions>> {
}
