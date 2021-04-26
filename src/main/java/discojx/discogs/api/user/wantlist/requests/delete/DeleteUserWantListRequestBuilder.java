package discojx.discogs.api.user.wantlist.requests.delete;

public interface DeleteUserWantListRequestBuilder {

    DeleteUserWantListRequestBuilder username(String username);
    DeleteUserWantListRequestBuilder releaseId(long releaseId);

    DeleteUserWantListRequest build();
}
