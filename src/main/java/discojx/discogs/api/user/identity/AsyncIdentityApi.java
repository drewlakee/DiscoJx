package discojx.discogs.api.user.identity;

import discojx.discogs.api.user.identity.requests.AsyncUserIdentityRequest;
import discojx.discogs.api.user.identity.requests.profile.AsyncProfileRequestBuilder;
import discojx.discogs.api.user.identity.requests.profile.edit.AsyncProfileEditRequestBuilder;
import discojx.discogs.api.user.identity.requests.submissions.AsyncUserSubmissionsRequestBuilder;

public interface AsyncIdentityApi {

    AsyncUserIdentityRequest self();
    AsyncProfileRequestBuilder profile();
    AsyncProfileEditRequestBuilder profileEdit();
    AsyncUserSubmissionsRequestBuilder submissions();
}
