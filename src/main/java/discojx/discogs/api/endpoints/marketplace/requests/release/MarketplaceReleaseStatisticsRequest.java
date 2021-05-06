package discojx.discogs.api.endpoints.marketplace.requests.release;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.MarketplaceReleaseStatistics;

public interface MarketplaceReleaseStatisticsRequest extends AsyncExecutableRequest<EntityResponseWrapper<MarketplaceReleaseStatistics>> {
}