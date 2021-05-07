package discojx.discogs.api.endpoints.database.requests.label;

import discojx.discogs.api.requests.AsyncExecutableRequest;
import discojx.discogs.objects.lib.EntityResponseWrapper;
import discojx.discogs.objects.models.Label;

public interface LabelRequest extends AsyncExecutableRequest<EntityResponseWrapper<Label>> {
}
