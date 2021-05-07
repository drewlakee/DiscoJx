package discojx.discogs.api.endpoints.inventory.upload.requests.recent;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.requests.GetRecentUploads;

public interface GetRecentUploadsRequest extends AsyncExecutableRequest<EntityResponseWrapper<GetRecentUploads>> {
}
