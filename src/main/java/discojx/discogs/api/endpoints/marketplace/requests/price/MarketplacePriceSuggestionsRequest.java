package discojx.discogs.api.endpoints.marketplace.requests.price;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.requests.MarketplacePriceSuggestions;

public interface MarketplacePriceSuggestionsRequest extends AsyncExecutableRequest<EntityResponseWrapper<MarketplacePriceSuggestions>> {
}
