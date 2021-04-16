package discojx.discogs.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import discojx.utils.deserializers.UrlsArrayListDeserializer;

import java.net.URL;
import java.util.List;
import java.util.Objects;

public class Pagination {

    private int page;
    private int pages;
    @JsonProperty("per_page")
    private int perPage;
    private int items;
    @JsonDeserialize(using = UrlsArrayListDeserializer.class)
    private List<URL> urls;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public List<URL> getUrls() {
        return urls;
    }

    public void setUrls(List<URL> urls) {
        this.urls = urls;
    }

    @Override
    public String toString() {
        return "Pagination{" +
                "page=" + page +
                ", pages=" + pages +
                ", perPage=" + perPage +
                ", items=" + items +
                ", urls=" + urls +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagination that = (Pagination) o;
        return page == that.page && pages == that.pages && perPage == that.perPage && items == that.items && Objects.equals(urls, that.urls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(page, pages, perPage, items, urls);
    }
}
