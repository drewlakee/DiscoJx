package discojx.discogs.api.endpoints.database.requests.search;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.requests.SearchResults;

public interface SearchRequest extends AsyncExecutableRequest<EntityResponseWrapper<SearchResults>> {
}
