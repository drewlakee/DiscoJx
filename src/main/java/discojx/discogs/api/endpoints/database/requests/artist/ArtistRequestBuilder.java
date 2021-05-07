package discojx.discogs.api.endpoints.database.requests.artist;

import discojx.discogs.api.requests.RequestBuilder;

public interface ArtistRequestBuilder extends RequestBuilder<ArtistRequest> {

    ArtistRequestBuilder artistId(long artistId);
}
