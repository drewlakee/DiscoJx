package discojx.discogs.api.endpoints.user.identity.requests.profile.edit;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.Profile;

public interface ProfileEditRequest extends AsyncExecutableRequest<EntityResponseWrapper<Profile>> {
}
