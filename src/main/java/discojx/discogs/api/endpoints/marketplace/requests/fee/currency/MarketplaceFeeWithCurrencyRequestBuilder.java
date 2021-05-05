package discojx.discogs.api.endpoints.marketplace.requests.fee.currency;

import discojx.discogs.api.requests.RequestBuilder;

public interface MarketplaceFeeWithCurrencyRequestBuilder extends RequestBuilder<MarketplaceFeeWithCurrencyRequest> {

    MarketplaceFeeWithCurrencyRequestBuilder price(double price);
    MarketplaceFeeWithCurrencyRequestBuilder currency(String currency);
}
