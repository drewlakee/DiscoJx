package discojx.discogs.api.endpoints.user.collection.requests.fields;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.ListCustomFields;

public interface ListCustomFieldsRequest extends AsyncExecutableRequest<EntityResponseWrapper<ListCustomFields>> {
}
