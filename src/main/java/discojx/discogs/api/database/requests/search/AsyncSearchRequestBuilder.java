package discojx.discogs.api.database.requests.search;

import discojx.requests.PaginationableRequest;
import discojx.requests.ParameterizedRequest;
import discojx.utils.requests.RequestParametersConstructor;

public interface AsyncSearchRequestBuilder extends
        PaginationableRequest<AsyncSearchRequestBuilder>,
        ParameterizedRequest<RequestParametersConstructor> {

    AsyncSearchRequestBuilder query(String query);
    AsyncSearchRequestBuilder type(String type);
    AsyncSearchRequestBuilder title(String title);
    AsyncSearchRequestBuilder releaseTitle(String releaseTitle);
    AsyncSearchRequestBuilder credit(String credit);
    AsyncSearchRequestBuilder artist(String artist);
    AsyncSearchRequestBuilder anv(String anv);
    AsyncSearchRequestBuilder label(String label);
    AsyncSearchRequestBuilder genre(String genre);
    AsyncSearchRequestBuilder style(String style);
    AsyncSearchRequestBuilder country(String country);
    AsyncSearchRequestBuilder year(int year);
    AsyncSearchRequestBuilder format(String format);
    AsyncSearchRequestBuilder catno(String catno);
    AsyncSearchRequestBuilder barcode(String barcode);
    AsyncSearchRequestBuilder track(String track);
    AsyncSearchRequestBuilder submitter(String submitter);
    AsyncSearchRequestBuilder contributor(String contributor);

    AsyncSearchRequest build();
}
