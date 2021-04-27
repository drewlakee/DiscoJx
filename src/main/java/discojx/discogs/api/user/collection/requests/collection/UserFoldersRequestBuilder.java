package discojx.discogs.api.user.collection.requests.collection;

import discojx.requests.RequestBuilder;

public interface UserFoldersRequestBuilder extends RequestBuilder<UserFoldersRequest> {

    UserFoldersRequestBuilder username(String username);
}
