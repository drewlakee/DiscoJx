package discojx.discogs.api.marketplace.requests.fee.currency;

import discojx.requests.RequestBuilder;

public interface MarketplaceFeeWithCurrencyRequestBuilder extends RequestBuilder<MarketplaceFeeWithCurrencyRequest> {

    MarketplaceFeeWithCurrencyRequestBuilder price(double price);
    MarketplaceFeeWithCurrencyRequestBuilder currency(String currency);
}
