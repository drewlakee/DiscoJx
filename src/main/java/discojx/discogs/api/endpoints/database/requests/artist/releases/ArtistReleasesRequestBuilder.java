package discojx.discogs.api.endpoints.database.requests.artist.releases;

import discojx.discogs.api.requests.PaginationableRequest;
import discojx.discogs.api.requests.RequestBuilder;
import discojx.discogs.api.requests.SortableRequest;

public interface ArtistReleasesRequestBuilder extends RequestBuilder<ArtistReleasesRequest>,
        PaginationableRequest<ArtistReleasesRequestBuilder>,
        SortableRequest<ArtistReleasesRequestBuilder> {

    ArtistReleasesRequestBuilder artistId(long artistId);
}
