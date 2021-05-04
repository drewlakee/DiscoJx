package discojx.discogs.api.marketplace.requests.release;

import discojx.requests.RequestBuilder;

public interface MarketplaceReleaseStatisticsRequestBuilder extends RequestBuilder<MarketplaceReleaseStatisticsRequest> {

    MarketplaceReleaseStatisticsRequestBuilder releaseId(long releaseId);
    MarketplaceReleaseStatisticsRequestBuilder currAbbr(String currAbbr);
}
