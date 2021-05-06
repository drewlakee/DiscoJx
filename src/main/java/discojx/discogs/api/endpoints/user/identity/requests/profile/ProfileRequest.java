package discojx.discogs.api.endpoints.user.identity.requests.profile;

import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.Profile;
import discojx.discogs.api.requests.AsyncExecutableRequest;

public interface ProfileRequest extends AsyncExecutableRequest<EntityResponseWrapper<Profile>> {
}
