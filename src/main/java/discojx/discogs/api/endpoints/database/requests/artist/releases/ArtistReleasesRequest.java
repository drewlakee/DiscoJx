package discojx.discogs.api.endpoints.database.requests.artist.releases;

import com.fasterxml.jackson.databind.JsonNode;
import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.lib.EntityResponseWrapper;

public interface ArtistReleasesRequest extends AsyncExecutableRequest<EntityResponseWrapper<JsonNode>> {
}
