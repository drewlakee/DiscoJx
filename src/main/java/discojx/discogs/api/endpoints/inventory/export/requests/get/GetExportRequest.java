package discojx.discogs.api.endpoints.inventory.export.requests.get;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.ExportItem;

public interface GetExportRequest extends AsyncExecutableRequest<EntityResponseWrapper<ExportItem>> {
}
