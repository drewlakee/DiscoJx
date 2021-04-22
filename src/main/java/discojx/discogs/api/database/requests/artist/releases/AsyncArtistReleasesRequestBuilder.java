package discojx.discogs.api.database.requests.artist.releases;

import discojx.requests.PaginationableRequest;
import discojx.requests.ParameterizedRequest;
import discojx.requests.SortableRequest;

public interface AsyncArtistReleasesRequestBuilder extends
        PaginationableRequest<AsyncArtistReleasesRequestBuilder>,
        SortableRequest<AsyncArtistReleasesRequestBuilder>,
        ParameterizedRequest<String> {

    AsyncArtistReleasesRequestBuilder artistId(long artistId);

    AsyncArtistReleasesRequest build();
}
