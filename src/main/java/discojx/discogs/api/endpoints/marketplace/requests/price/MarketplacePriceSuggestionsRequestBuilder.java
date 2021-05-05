package discojx.discogs.api.endpoints.marketplace.requests.price;

import discojx.discogs.api.requests.RequestBuilder;

public interface MarketplacePriceSuggestionsRequestBuilder extends RequestBuilder<MarketplacePriceSuggestionsRequest> {

    MarketplacePriceSuggestionsRequestBuilder releaseId(long releaseId);
}
