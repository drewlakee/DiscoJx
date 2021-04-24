package discojx.discogs.api.user.identity.requests.profile.edit;

import com.fasterxml.jackson.databind.node.ObjectNode;
import discojx.discogs.objects.MarketplaceCurrencies;
import discojx.requests.JsonParameterizedRequest;

public interface ProfileEditRequestBuilder extends JsonParameterizedRequest<ObjectNode> {

    ProfileEditRequestBuilder username(String username);
    ProfileEditRequestBuilder name(String name);
    ProfileEditRequestBuilder homePage(String homePage);
    ProfileEditRequestBuilder location(String location);
    ProfileEditRequestBuilder profile(String profile);
    ProfileEditRequestBuilder currAbbr(MarketplaceCurrencies currency);

    ProfileEditRequest build();
}
