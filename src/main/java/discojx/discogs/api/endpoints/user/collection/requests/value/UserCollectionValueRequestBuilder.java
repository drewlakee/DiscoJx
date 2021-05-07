package discojx.discogs.api.endpoints.user.collection.requests.value;

import discojx.discogs.api.requests.RequestBuilder;

public interface UserCollectionValueRequestBuilder extends RequestBuilder<UserCollectionValueRequest> {

    UserCollectionValueRequestBuilder username(String username);
}
