package discojx.discogs.api.endpoints.user.collection.requests.value;

import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.UserCollectionValue;
import discojx.discogs.api.requests.AsyncExecutableRequest;

public interface UserCollectionValueRequest extends AsyncExecutableRequest<EntityResponseWrapper<UserCollectionValue>> {
}
