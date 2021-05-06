package discojx.discogs.api.endpoints.database.requests.release;

import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.Release;
import discojx.discogs.api.requests.AsyncExecutableRequest;

public interface ReleaseRequest extends AsyncExecutableRequest<EntityResponseWrapper<Release>> {
}
