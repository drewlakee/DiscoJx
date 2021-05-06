package discojx.discogs.api.endpoints.inventory.upload.requests.recent.get;

import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.UploadItem;
import discojx.discogs.api.requests.AsyncExecutableRequest;

public interface GetUploadRequest extends AsyncExecutableRequest<EntityResponseWrapper<UploadItem>> {
}
