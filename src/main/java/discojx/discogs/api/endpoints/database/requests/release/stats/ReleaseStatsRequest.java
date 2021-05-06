package discojx.discogs.api.endpoints.database.requests.release.stats;

import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.ReleaseStats;
import discojx.discogs.api.requests.AsyncExecutableRequest;

public interface ReleaseStatsRequest extends AsyncExecutableRequest<EntityResponseWrapper<ReleaseStats>> {
}
