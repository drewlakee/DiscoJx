package discojx.discogs.objects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import discojx.utils.deserializers.SearchResultDeserializer;

import java.util.List;
import java.util.Objects;

public class SearchResult {

    private Pagination pagination;
    @JsonDeserialize(using = SearchResultDeserializer.class)
    private List<AbstractTypedSearchResult> results;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<AbstractTypedSearchResult> getResults() {
        return results;
    }

    public void setResults(List<AbstractTypedSearchResult> results) {
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
        SearchResult that = (SearchResult) o;
        return Objects.equals(pagination, that.pagination) && Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pagination, results);
    }
}
