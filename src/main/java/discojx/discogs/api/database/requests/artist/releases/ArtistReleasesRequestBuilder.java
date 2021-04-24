package discojx.discogs.api.database.requests.artist.releases;

import discojx.requests.PaginationableRequest;
import discojx.requests.PathParameterizedRequest;
import discojx.requests.SortableRequest;
import discojx.utils.requests.RequestParametersConstructor;

public interface ArtistReleasesRequestBuilder extends
        PaginationableRequest<ArtistReleasesRequestBuilder>,
        SortableRequest<ArtistReleasesRequestBuilder>,
        PathParameterizedRequest<RequestParametersConstructor> {

    ArtistReleasesRequestBuilder artistId(long artistId);

    ArtistReleasesRequest build();
}
