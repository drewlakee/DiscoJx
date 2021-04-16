package discojx.discogs.api.user.identity.requests.submissions;

public interface AsyncUserSubmissionsRequestBuilder {

    AsyncUserSubmissionsRequestBuilder username(String username);

    AsyncUserSubmissionsRequest build();
}
