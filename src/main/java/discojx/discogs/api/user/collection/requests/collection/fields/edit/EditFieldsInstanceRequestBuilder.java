package discojx.discogs.api.user.collection.requests.collection.fields.edit;

import discojx.requests.RequestBuilder;

public interface EditFieldsInstanceRequestBuilder extends RequestBuilder<EditFieldsInstanceRequest> {

    EditFieldsInstanceRequestBuilder username(String username);
    EditFieldsInstanceRequestBuilder value(String value);
    EditFieldsInstanceRequestBuilder folderId(long folderId);
    EditFieldsInstanceRequestBuilder releaseId(long releaseId);
    EditFieldsInstanceRequestBuilder instanceId(long instanceId);
    EditFieldsInstanceRequestBuilder fieldId(long fieldId);
}
