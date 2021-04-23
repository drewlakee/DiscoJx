package discojx.discogs.api.database.requests.search;

import discojx.requests.PaginationableRequest;
import discojx.requests.ParameterizedRequest;
import discojx.utils.requests.RequestParametersConstructor;

public interface SearchRequestBuilder extends
        PaginationableRequest<SearchRequestBuilder>,
        ParameterizedRequest<RequestParametersConstructor> {

    SearchRequestBuilder query(String query);
    SearchRequestBuilder type(String type);
    SearchRequestBuilder title(String title);
    SearchRequestBuilder releaseTitle(String releaseTitle);
    SearchRequestBuilder credit(String credit);
    SearchRequestBuilder artist(String artist);
    SearchRequestBuilder anv(String anv);
    SearchRequestBuilder label(String label);
    SearchRequestBuilder genre(String genre);
    SearchRequestBuilder style(String style);
    SearchRequestBuilder country(String country);
    SearchRequestBuilder year(int year);
    SearchRequestBuilder format(String format);
    SearchRequestBuilder catno(String catno);
    SearchRequestBuilder barcode(String barcode);
    SearchRequestBuilder track(String track);
    SearchRequestBuilder submitter(String submitter);
    SearchRequestBuilder contributor(String contributor);

    SearchRequest build();
}
