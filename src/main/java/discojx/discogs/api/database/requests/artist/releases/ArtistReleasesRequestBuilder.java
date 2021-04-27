package discojx.discogs.api.database.requests.artist.releases;

import discojx.requests.PaginationableRequest;
import discojx.requests.RequestBuilder;
import discojx.requests.SortableRequest;

public interface ArtistReleasesRequestBuilder extends RequestBuilder<ArtistReleasesRequest>,
        PaginationableRequest<ArtistReleasesRequestBuilder>,
        SortableRequest<ArtistReleasesRequestBuilder> {

    ArtistReleasesRequestBuilder artistId(long artistId);
}
