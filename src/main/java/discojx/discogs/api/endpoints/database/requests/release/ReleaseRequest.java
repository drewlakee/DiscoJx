package discojx.discogs.api.endpoints.database.requests.release;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.Release;

public interface ReleaseRequest extends AsyncExecutableRequest<EntityResponseWrapper<Release>> {
}
