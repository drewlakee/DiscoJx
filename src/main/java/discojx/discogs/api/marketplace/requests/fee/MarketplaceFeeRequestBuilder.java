package discojx.discogs.api.marketplace.requests.fee;

import discojx.requests.RequestBuilder;

public interface MarketplaceFeeRequestBuilder extends RequestBuilder<MarketplaceFeeRequest> {

    MarketplaceFeeRequestBuilder price(double price);
}
