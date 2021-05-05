package discojx.discogs.api.endpoints.marketplace;

import discojx.discogs.api.endpoints.marketplace.inventory.MarketplaceInventoryApi;
import discojx.discogs.api.endpoints.marketplace.listing.MarketplaceListingApi;
import discojx.discogs.api.endpoints.marketplace.order.MarketplaceOrderApi;
import discojx.discogs.api.endpoints.marketplace.requests.fee.MarketplaceFeeRequestBuilder;
import discojx.discogs.api.endpoints.marketplace.requests.fee.currency.MarketplaceFeeWithCurrencyRequestBuilder;
import discojx.discogs.api.endpoints.marketplace.requests.price.MarketplacePriceSuggestionsRequestBuilder;
import discojx.discogs.api.endpoints.marketplace.requests.release.MarketplaceReleaseStatisticsRequestBuilder;

public interface MarketplaceApi {

    MarketplaceInventoryApi inventory();
    MarketplaceListingApi listing();
    MarketplaceOrderApi order();

    MarketplaceFeeRequestBuilder getFee();
    MarketplaceFeeWithCurrencyRequestBuilder getFeeWithCurrency();
    MarketplacePriceSuggestionsRequestBuilder getPriceSuggestions();
    MarketplaceReleaseStatisticsRequestBuilder getReleaseStatistics();
}
