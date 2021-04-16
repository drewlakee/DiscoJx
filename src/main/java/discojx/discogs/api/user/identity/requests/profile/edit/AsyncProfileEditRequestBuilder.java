package discojx.discogs.api.user.identity.requests.profile.edit;

import discojx.discogs.objects.MarketplaceCurrencies;

public interface AsyncProfileEditRequestBuilder {

    AsyncProfileEditRequestBuilder username(String username);
    AsyncProfileEditRequestBuilder name(String name);
    AsyncProfileEditRequestBuilder homePage(String homePage);
    AsyncProfileEditRequestBuilder location(String location);
    AsyncProfileEditRequestBuilder profile(String profile);
    AsyncProfileEditRequestBuilder currAbbr(MarketplaceCurrencies currency);

    AsyncProfileEditRequest build();
}
