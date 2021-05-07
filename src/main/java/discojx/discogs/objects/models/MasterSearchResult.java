package discojx.discogs.objects.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class MasterSearchResult extends SearchResult {

    public static class Community {
        private int want;
        private int have;

        public int getWant() {
            return want;
        }

        public void setWant(int want) {
            this.want = want;
        }

        public int getHave() {
            return have;
        }

        public void setHave(int have) {
            this.have = have;
        }

        @Override
        public String toString() {
            return "Community{" +
                    "want=" + want +
                    ", have=" + have +
                    '}';
        }

        @Override
        public boolean equals(Object o) {

            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Community community = (Community) o;
            return want == community.want && have == community.have;
        }

        @Override
        public int hashCode() {
            return Objects.hash(want, have);
        }
    }

    private String country;
    private int year;
    @JsonProperty("format")
    private List<String> formats;
    @JsonProperty("label")
    private List<String> labels;
    @JsonProperty("genre")
    private List<String> genres;
    @JsonProperty("style")
    private List<String> styles;
    @JsonProperty("barcode")
    private List<String> barcodes;
    private String catno;
    private Community community;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getFormats() {
        return formats;
    }

    public void setFormats(List<String> formats) {
        this.formats = formats;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<String> getStyles() {
        return styles;
    }

    public void setStyles(List<String> styles) {
        this.styles = styles;
    }

    public List<String> getBarcodes() {
        return barcodes;
    }

    public void setBarcodes(List<String> barcodes) {
        this.barcodes = barcodes;
    }

    public String getCatno() {
        return catno;
    }

    public void setCatno(String catno) {
        this.catno = catno;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    @Override
    public String toString() {
        return "MasterSearchResult{" +
                "type='" + type + '\'' +
                ", id=" + id +
                ", userData=" + userData +
                ", masterId=" + masterId +
                ", masterUrl='" + masterUrl + '\'' +
                ", resourceUrl='" + resourceUrl + '\'' +
                ", coverImage='" + coverImage + '\'' +
                ", uri='" + uri + '\'' +
                ", thumb='" + thumb + '\'' +
                ", country='" + country + '\'' +
                ", year=" + year +
                ", formats=" + formats +
                ", labels=" + labels +
                ", genres=" + genres +
                ", styles=" + styles +
                ", barcodes=" + barcodes +
                ", catno='" + catno + '\'' +
                ", community=" + community +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MasterSearchResult that = (MasterSearchResult) o;
        return year == that.year && Objects.equals(country, that.country) && Objects.equals(formats, that.formats) && Objects.equals(labels, that.labels) && Objects.equals(genres, that.genres) && Objects.equals(styles, that.styles) && Objects.equals(barcodes, that.barcodes) && Objects.equals(catno, that.catno) && Objects.equals(community, that.community);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), country, year, formats, labels, genres, styles, barcodes, catno, community);
    }
}
