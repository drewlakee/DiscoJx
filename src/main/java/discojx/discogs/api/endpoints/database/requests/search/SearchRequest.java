package discojx.discogs.api.endpoints.database.requests.search;

import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.requests.SearchResults;
import discojx.discogs.api.requests.AsyncExecutableRequest;

public interface SearchRequest extends AsyncExecutableRequest<EntityResponseWrapper<SearchResults>> {
}
