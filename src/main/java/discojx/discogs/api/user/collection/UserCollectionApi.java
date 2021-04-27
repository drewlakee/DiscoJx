package discojx.discogs.api.user.collection;

import discojx.discogs.api.user.collection.requests.folders.UserFoldersRequestBuilder;

public interface UserCollectionApi {

    UserFoldersRequestBuilder folders();
}
