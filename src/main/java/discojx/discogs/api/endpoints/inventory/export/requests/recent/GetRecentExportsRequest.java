package discojx.discogs.api.endpoints.inventory.export.requests.recent;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.requests.GetRecentExports;

public interface GetRecentExportsRequest extends AsyncExecutableRequest<EntityResponseWrapper<GetRecentExports>> {
}
