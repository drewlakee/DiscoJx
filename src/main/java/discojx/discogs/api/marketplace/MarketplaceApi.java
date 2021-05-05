package discojx.discogs.api.marketplace;

import discojx.discogs.api.marketplace.inventory.MarketplaceInventoryApi;
import discojx.discogs.api.marketplace.listing.MarketplaceListingApi;
import discojx.discogs.api.marketplace.order.MarketplaceOrderApi;
import discojx.discogs.api.marketplace.requests.fee.MarketplaceFeeRequestBuilder;
import discojx.discogs.api.marketplace.requests.fee.currency.MarketplaceFeeWithCurrencyRequestBuilder;
import discojx.discogs.api.marketplace.requests.price.MarketplacePriceSuggestionsRequestBuilder;
import discojx.discogs.api.marketplace.requests.release.MarketplaceReleaseStatisticsRequestBuilder;

public interface MarketplaceApi {

    MarketplaceInventoryApi inventory();
    MarketplaceListingApi listing();
    MarketplaceOrderApi order();

    MarketplaceFeeRequestBuilder getFee();
    MarketplaceFeeWithCurrencyRequestBuilder getFeeWithCurrency();
    MarketplacePriceSuggestionsRequestBuilder getPriceSuggestions();
    MarketplaceReleaseStatisticsRequestBuilder getReleaseStatistics();
}
