package discojx.discogs.api.endpoints.user.collection.requests.fields;

import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.ListCustomFields;
import discojx.discogs.api.requests.AsyncExecutableRequest;

public interface ListCustomFieldsRequest extends AsyncExecutableRequest<EntityResponseWrapper<ListCustomFields>> {
}
