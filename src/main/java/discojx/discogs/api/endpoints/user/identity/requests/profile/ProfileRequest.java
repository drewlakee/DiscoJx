package discojx.discogs.api.endpoints.user.identity.requests.profile;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.Profile;

public interface ProfileRequest extends AsyncExecutableRequest<EntityResponseWrapper<Profile>> {
}
