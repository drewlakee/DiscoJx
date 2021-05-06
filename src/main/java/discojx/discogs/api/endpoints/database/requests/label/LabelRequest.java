package discojx.discogs.api.endpoints.database.requests.label;

import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.Label;
import discojx.discogs.api.requests.AsyncExecutableRequest;

public interface LabelRequest extends AsyncExecutableRequest<EntityResponseWrapper<Label>> {
}
