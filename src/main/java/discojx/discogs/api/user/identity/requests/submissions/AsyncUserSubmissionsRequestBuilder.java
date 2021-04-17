package discojx.discogs.api.user.identity.requests.submissions;

public interface AsyncUserSubmissionsRequestBuilder {

    AsyncUserSubmissionsRequestBuilder username(String username);
    AsyncUserSubmissionsRequestBuilder page(int page);
    AsyncUserSubmissionsRequestBuilder perPage(int perPage);

    AsyncUserSubmissionsRequest build();
}
