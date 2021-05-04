package discojx.discogs.api.marketplace.requests.price;

import discojx.requests.RequestBuilder;

public interface MarketplacePriceSuggestionsRequestBuilder extends RequestBuilder<MarketplacePriceSuggestionsRequest> {

    MarketplacePriceSuggestionsRequestBuilder releaseId(long releaseId);
}
