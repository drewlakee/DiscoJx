package discojx.discogs.api.endpoints.database.requests.release.master;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.MasterRelease;

public interface MasterReleaseRequest extends AsyncExecutableRequest<EntityResponseWrapper<MasterRelease>> {
}
