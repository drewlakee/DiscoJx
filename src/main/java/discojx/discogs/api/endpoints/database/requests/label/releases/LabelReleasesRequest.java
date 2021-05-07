package discojx.discogs.api.endpoints.database.requests.label.releases;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.requests.LabelReleases;

public interface LabelReleasesRequest extends AsyncExecutableRequest<EntityResponseWrapper<LabelReleases>> {
}
