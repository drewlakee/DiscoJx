package discojx.discogs.api.endpoints.database.requests.artist.releases;

import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.requests.ArtistReleases;
import discojx.discogs.api.requests.AsyncExecutableRequest;

public interface ArtistReleasesRequest extends AsyncExecutableRequest<EntityResponseWrapper<ArtistReleases>> {
}
