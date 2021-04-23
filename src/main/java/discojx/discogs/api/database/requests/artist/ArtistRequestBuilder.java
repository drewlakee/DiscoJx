package discojx.discogs.api.database.requests.artist;

public interface ArtistRequestBuilder {

    ArtistRequestBuilder artistId(long artistId);

    ArtistRequest build();
}
