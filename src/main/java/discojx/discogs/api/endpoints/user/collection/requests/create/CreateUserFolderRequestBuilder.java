package discojx.discogs.api.endpoints.user.collection.requests.create;

import discojx.discogs.api.requests.RequestBuilder;

public interface CreateUserFolderRequestBuilder extends RequestBuilder<CreateUserFolderRequest> {

    CreateUserFolderRequestBuilder username(String username);
    CreateUserFolderRequestBuilder name(String name);
}
