package discojx.discogs.api.endpoints.database.requests.release.master.versions;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.MasterReleaseVersions;

public interface MasterReleaseVersionsRequest extends AsyncExecutableRequest<EntityResponseWrapper<MasterReleaseVersions>> {
}
