package discojx.discogs.api.user.identity.requests.profile.edit;

import discojx.discogs.objects.MarketplaceCurrencies;

public interface ProfileEditRequestBuilder {

    ProfileEditRequestBuilder username(String username);
    ProfileEditRequestBuilder name(String name);
    ProfileEditRequestBuilder homePage(String homePage);
    ProfileEditRequestBuilder location(String location);
    ProfileEditRequestBuilder profile(String profile);
    ProfileEditRequestBuilder currAbbr(MarketplaceCurrencies currency);

    ProfileEditRequest build();
}
