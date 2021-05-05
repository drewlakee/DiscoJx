package discojx.discogs.api.endpoints.user.collection.requests.fields;

import discojx.discogs.api.requests.RequestBuilder;

public interface ListCustomFieldsRequestBuilder extends RequestBuilder<ListCustomFieldsRequest> {

    ListCustomFieldsRequestBuilder username(String username);
}
