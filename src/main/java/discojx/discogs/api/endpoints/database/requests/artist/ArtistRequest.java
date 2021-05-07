package discojx.discogs.api.endpoints.database.requests.artist;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.Artist;

public interface ArtistRequest extends AsyncExecutableRequest<EntityResponseWrapper<Artist>> {
}
