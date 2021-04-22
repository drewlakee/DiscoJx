package discojx.discogs.api.database.requests.artist.releases;

import discojx.requests.PaginationableRequest;
import discojx.requests.SortableRequest;

public interface AsyncArtistReleasesRequestBuilder extends PaginationableRequest<AsyncArtistReleasesRequestBuilder>, SortableRequest<AsyncArtistReleasesRequestBuilder> {

    AsyncArtistReleasesRequestBuilder artistId(long artistId);

    AsyncArtistReleasesRequest build();
}
