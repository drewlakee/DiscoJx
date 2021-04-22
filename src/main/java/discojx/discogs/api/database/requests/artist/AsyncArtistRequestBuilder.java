package discojx.discogs.api.database.requests.artist;

public interface AsyncArtistRequestBuilder {

    AsyncArtistRequestBuilder artistId(long artistId);

    AsyncArtistRequest build();
}
