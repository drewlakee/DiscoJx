package discojx.discogs.api.endpoints.database.requests.artist;

import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.Artist;
import discojx.discogs.api.requests.AsyncExecutableRequest;

public interface ArtistRequest extends AsyncExecutableRequest<EntityResponseWrapper<Artist>> {
}
