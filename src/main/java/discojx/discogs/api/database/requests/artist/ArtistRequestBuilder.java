package discojx.discogs.api.database.requests.artist;

import discojx.requests.RequestBuilder;

public interface ArtistRequestBuilder extends RequestBuilder<ArtistRequest> {

    ArtistRequestBuilder artistId(long artistId);
}
