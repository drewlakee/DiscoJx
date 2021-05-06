package discojx.discogs.api.endpoints.inventory.export.requests.get;

import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.ExportItem;
import discojx.discogs.api.requests.AsyncExecutableRequest;

public interface GetExportRequest extends AsyncExecutableRequest<EntityResponseWrapper<ExportItem>> {
}
