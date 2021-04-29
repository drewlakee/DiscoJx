package discojx.discogs.api.user.collection.requests.collection.value;

import discojx.requests.RequestBuilder;

public interface UserCollectionValueRequestBuilder extends RequestBuilder<UserCollectionValueRequest> {

    UserCollectionValueRequestBuilder username(String username);
}
