package discojx.discogs.api.endpoints.database.requests.release.master.versions;

import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.MasterReleaseVersions;
import discojx.discogs.api.requests.AsyncExecutableRequest;

public interface MasterReleaseVersionsRequest extends AsyncExecutableRequest<EntityResponseWrapper<MasterReleaseVersions>> {
}
