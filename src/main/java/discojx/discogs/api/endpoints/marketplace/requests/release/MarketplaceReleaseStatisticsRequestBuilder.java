package discojx.discogs.api.endpoints.marketplace.requests.release;

import discojx.discogs.api.requests.RequestBuilder;

public interface MarketplaceReleaseStatisticsRequestBuilder extends RequestBuilder<MarketplaceReleaseStatisticsRequest> {

    MarketplaceReleaseStatisticsRequestBuilder releaseId(long releaseId);
    MarketplaceReleaseStatisticsRequestBuilder currAbbr(String currAbbr);
}
