package discojx.discogs.api.endpoints.inventory.upload.requests.recent;

import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.requests.GetRecentUploads;
import discojx.discogs.api.requests.AsyncExecutableRequest;

public interface GetRecentUploadsRequest extends AsyncExecutableRequest<EntityResponseWrapper<GetRecentUploads>> {
}
