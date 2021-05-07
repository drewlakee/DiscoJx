package discojx.discogs.api.endpoints.database.requests.release.stats;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.ReleaseStats;

public interface ReleaseStatsRequest extends AsyncExecutableRequest<EntityResponseWrapper<ReleaseStats>> {
}
