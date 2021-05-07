package discojx.discogs.api.endpoints.marketplace.requests.fee;

import discojx.discogs.api.requests.RequestBuilder;

public interface MarketplaceFeeRequestBuilder extends RequestBuilder<MarketplaceFeeRequest> {

    MarketplaceFeeRequestBuilder price(double price);
}
