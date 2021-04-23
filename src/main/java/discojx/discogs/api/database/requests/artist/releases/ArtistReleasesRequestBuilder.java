package discojx.discogs.api.database.requests.artist.releases;

import discojx.requests.PaginationableRequest;
import discojx.requests.ParameterizedRequest;
import discojx.requests.SortableRequest;
import discojx.utils.requests.RequestParametersConstructor;

public interface ArtistReleasesRequestBuilder extends
        PaginationableRequest<ArtistReleasesRequestBuilder>,
        SortableRequest<ArtistReleasesRequestBuilder>,
        ParameterizedRequest<RequestParametersConstructor> {

    ArtistReleasesRequestBuilder artistId(long artistId);

    ArtistReleasesRequest build();
}
