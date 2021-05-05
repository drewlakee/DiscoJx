package discojx.discogs.api.endpoints.user.collection.requests;

import discojx.discogs.api.requests.RequestBuilder;

public interface UserFoldersRequestBuilder extends RequestBuilder<UserFoldersRequest> {

    UserFoldersRequestBuilder username(String username);
}
