package discojx.discogs.api.user.collection.requests.collection.create;

import discojx.requests.RequestBuilder;

public interface CreateUserFolderRequestBuilder extends RequestBuilder<CreateUserFolderRequest> {

    CreateUserFolderRequestBuilder username(String username);
    CreateUserFolderRequestBuilder name(String name);
}
