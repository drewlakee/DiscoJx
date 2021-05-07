package discojx.discogs.objects.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import discojx.discogs.objects.models.SearchResult;
import discojx.utils.json.deserializers.SearchResultsDeserializer;

import java.util.List;
import java.util.Objects;

public class SearchResults {

    private Pagination pagination;
    @JsonDeserialize(using = SearchResultsDeserializer.class)
    private List<SearchResult> results;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<SearchResult> getResults() {
        return results;
    }

    public void setResults(List<SearchResult> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "pagination=" + pagination +
                ", results=" + results +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchResults that = (SearchResults) o;
        return Objects.equals(pagination, that.pagination) && Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pagination, results);
    }
}
