package discojx.discogs.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class MasterSearchResult extends AbstractTypedSearchResult {

    public static class UserData {
        @JsonProperty("in_wantlist")
        private boolean inWantList;
        @JsonProperty("in_collection")
        private boolean inCollection;

        public boolean isInWantList() {
            return inWantList;
        }

        public void setInWantList(boolean inWantList) {
            this.inWantList = inWantList;
        }

        public boolean isInCollection() {
            return inCollection;
        }

        public void setInCollection(boolean inCollection) {
            this.inCollection = inCollection;
        }

        @Override
        public String toString() {
            return "UserData{" +
                    "inWantList=" + inWantList +
                    ", inCollection=" + inCollection +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UserData userData = (UserData) o;
            return inWantList == userData.inWantList && inCollection == userData.inCollection;
        }

        @Override
        public int hashCode() {
            return Objects.hash(inWantList, inCollection);
        }
    }

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
    private long id;
    @JsonProperty("barcode")
    private List<String> barcodes;
    @JsonProperty("user_data")
    private UserData userData;
    @JsonProperty("master_id")
    private long masterId;
    @JsonProperty("master_url")
    private String masterUrl;
    private String uri;
    private String catno;
    private String thumb;
    @JsonProperty("cover_image")
    private String coverImage;
    @JsonProperty("resource_url")
    private String resourceUrl;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<String> getBarcodes() {
        return barcodes;
    }

    public void setBarcodes(List<String> barcodes) {
        this.barcodes = barcodes;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public long getMasterId() {
        return masterId;
    }

    public void setMasterId(long masterId) {
        this.masterId = masterId;
    }

    public String getMasterUrl() {
        return masterUrl;
    }

    public void setMasterUrl(String masterUrl) {
        this.masterUrl = masterUrl;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getCatno() {
        return catno;
    }

    public void setCatno(String catno) {
        this.catno = catno;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
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
                "country='" + country + '\'' +
                ", year=" + year +
                ", formats=" + formats +
                ", labels=" + labels +
                ", genres=" + genres +
                ", styles=" + styles +
                ", id=" + id +
                ", barcodes=" + barcodes +
                ", userData=" + userData +
                ", masterId=" + masterId +
                ", masterUrl=" + masterUrl +
                ", uri=" + uri +
                ", catno='" + catno + '\'' +
                ", thumb=" + thumb +
                ", coverImage=" + coverImage +
                ", resourceUrl=" + resourceUrl +
                ", community=" + community +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MasterSearchResult that = (MasterSearchResult) o;
        return year == that.year && id == that.id && masterId == that.masterId && Objects.equals(country, that.country) && Objects.equals(formats, that.formats) && Objects.equals(labels, that.labels) && Objects.equals(genres, that.genres) && Objects.equals(styles, that.styles) && Objects.equals(barcodes, that.barcodes) && Objects.equals(userData, that.userData) && Objects.equals(masterUrl, that.masterUrl) && Objects.equals(uri, that.uri) && Objects.equals(catno, that.catno) && Objects.equals(thumb, that.thumb) && Objects.equals(coverImage, that.coverImage) && Objects.equals(resourceUrl, that.resourceUrl) && Objects.equals(community, that.community);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), country, year, formats, labels, genres, styles, id, barcodes, userData, masterId, masterUrl, uri, catno, thumb, coverImage, resourceUrl, community);
    }
}
