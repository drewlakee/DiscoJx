package discojx.discogs.api.endpoints.user.collection.requests.fields.edit;

import discojx.discogs.api.requests.RequestBuilder;

public interface EditFieldsInstanceRequestBuilder extends RequestBuilder<EditFieldsInstanceRequest> {

    EditFieldsInstanceRequestBuilder username(String username);
    EditFieldsInstanceRequestBuilder value(String value);
    EditFieldsInstanceRequestBuilder folderId(long folderId);
    EditFieldsInstanceRequestBuilder releaseId(long releaseId);
    EditFieldsInstanceRequestBuilder instanceId(long instanceId);
    EditFieldsInstanceRequestBuilder fieldId(long fieldId);
}
