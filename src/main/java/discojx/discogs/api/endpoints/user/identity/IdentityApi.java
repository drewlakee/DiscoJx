package discojx.discogs.api.endpoints.user.identity;

import discojx.discogs.api.endpoints.user.identity.requests.UserIdentityRequest;
import discojx.discogs.api.endpoints.user.identity.requests.contributions.UserContributionsRequestBuilder;
import discojx.discogs.api.endpoints.user.identity.requests.profile.ProfileRequestBuilder;
import discojx.discogs.api.endpoints.user.identity.requests.profile.edit.ProfileEditRequestBuilder;
import discojx.discogs.api.endpoints.user.identity.requests.submissions.UserSubmissionsRequestBuilder;

public interface IdentityApi {

    UserIdentityRequest identifyYourself();
    ProfileRequestBuilder getProfile();
    ProfileEditRequestBuilder editProfile();
    UserSubmissionsRequestBuilder getSubmissions();
    UserContributionsRequestBuilder getContributions();
}
