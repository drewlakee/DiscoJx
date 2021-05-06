package discojx.discogs.api.endpoints.database.requests.artist.releases;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.requests.ArtistReleases;

public interface ArtistReleasesRequest extends AsyncExecutableRequest<EntityResponseWrapper<ArtistReleases>> {
}
