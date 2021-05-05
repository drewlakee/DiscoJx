package discojx.discogs.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Pagination {

    public static class Urls {
        private String last;
        private String next;
        private String first;
        private String prev;

        public String getLast() {
            return last;
        }

        public void setLast(String last) {
            this.last = last;
        }

        public String getNext() {
            return next;
        }

        public void setNext(String next) {
            this.next = next;
        }

        public String getFirst() {
            return first;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public String getPrev() {
            return prev;
        }

        public void setPrev(String prev) {
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "Urls{" +
                    "last=" + last +
                    ", next=" + next +
                    ", first=" + first +
                    ", prev=" + prev +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Urls urls = (Urls) o;
            return Objects.equals(last, urls.last) && Objects.equals(next, urls.next) && Objects.equals(first, urls.first) && Objects.equals(prev, urls.prev);
        }

        @Override
        public int hashCode() {
            return Objects.hash(last, next, first, prev);
        }
    }

    private int page;
    private int pages;
    @JsonProperty("per_page")
    private int perPage;
    private int items;
    private Urls urls;

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

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
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
