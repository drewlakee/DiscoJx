package discojx.discogs.api.endpoints.marketplace.listing.requests.create;

import discojx.discogs.api.requests.RequestBuilder;

public interface MarketplaceNewListingRequestBuilder extends RequestBuilder<MarketplaceNewListingRequest> {

    MarketplaceNewListingRequestBuilder releaseId(long releaseId);
    MarketplaceNewListingRequestBuilder condition(String condition);
    MarketplaceNewListingRequestBuilder sleeveCondition(String sleeveCondition);
    MarketplaceNewListingRequestBuilder price(double price);
    MarketplaceNewListingRequestBuilder comments(String comments);
    MarketplaceNewListingRequestBuilder allowOffers(boolean allowOffers);
    MarketplaceNewListingRequestBuilder status(String status);
    MarketplaceNewListingRequestBuilder externalId(long externalId);
    MarketplaceNewListingRequestBuilder location(String location);
    MarketplaceNewListingRequestBuilder weight(double weight);
    MarketplaceNewListingRequestBuilder formatQuantity(int formatQuantity);
}
