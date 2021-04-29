package discojx.discogs.api.user.collection.requests.collection.fields;

import discojx.requests.RequestBuilder;

public interface ListCustomFieldsRequestBuilder extends RequestBuilder<ListCustomFieldsRequest> {

    ListCustomFieldsRequestBuilder username(String username);
}
