package discojx.discogs.api.database.requests.artist.releases;

import discojx.requests.PaginationableRequest;
import discojx.requests.ParameterizedRequest;
import discojx.requests.SortableRequest;
import discojx.utils.requests.RequestParametersConstructor;

public interface AsyncArtistReleasesRequestBuilder extends
        PaginationableRequest<AsyncArtistReleasesRequestBuilder>,
        SortableRequest<AsyncArtistReleasesRequestBuilder>,
        ParameterizedRequest<RequestParametersConstructor> {

    AsyncArtistReleasesRequestBuilder artistId(long artistId);

    AsyncArtistReleasesRequest build();
}
