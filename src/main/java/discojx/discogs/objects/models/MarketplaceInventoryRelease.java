package discojx.discogs.objects.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class MarketplaceInventoryRelease {

    public static class Stats {

        public static class Community {
            @JsonProperty("in_wantlist")
            private int inWantList;
            @JsonProperty("in_collection")
            private int inCollection;

            public int getInWantList() {
                return inWantList;
            }

            public void setInWantList(int inWantList) {
                this.inWantList = inWantList;
            }

            public int getInCollection() {
                return inCollection;
            }

            public void setInCollection(int inCollection) {
                this.inCollection = inCollection;
            }

            @Override
            public String toString() {
                return "Community{" +
                        "inWantList=" + inWantList +
                        ", inCollection=" + inCollection +
                        '}';
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Community community = (Community) o;
                return inWantList == community.inWantList && inCollection == community.inCollection;
            }

            @Override
            public int hashCode() {
                return Objects.hash(inWantList, inCollection);
            }
        }

        private Community community;

        public Community getCommunity() {
            return community;
        }

        public void setCommunity(Community community) {
            this.community = community;
        }

        @Override
        public String toString() {
            return "Stats{" +
                    "community=" + community +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Stats stats = (Stats) o;
            return Objects.equals(community, stats.community);
        }

        @Override
        public int hashCode() {
            return Objects.hash(community);
        }
    }

    private String thumbnail;
    private String description;
    private List<Image> images;
    private String artist;
    private String format;
    @JsonProperty("resource_url")
    private String resourceUrl;
    private String title;
    private int year;
    private long id;
    @JsonProperty("catalog_number")
    private String catalogNumber;
    private Stats stats;

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCatalogNumber() {
        return catalogNumber;
    }

    public void setCatalogNumber(String catalogNumber) {
        this.catalogNumber = catalogNumber;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    @Override
    public String toString() {
        return "MarketplaceInventoryRelease{" +
                "thumbnail='" + thumbnail + '\'' +
                ", description='" + description + '\'' +
                ", images=" + images +
                ", artist='" + artist + '\'' +
                ", format='" + format + '\'' +
                ", resourceUrl='" + resourceUrl + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", id=" + id +
                ", catalogNumber='" + catalogNumber + '\'' +
                ", stats=" + stats +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarketplaceInventoryRelease that = (MarketplaceInventoryRelease) o;
        return year == that.year && id == that.id && Objects.equals(thumbnail, that.thumbnail) && Objects.equals(description, that.description) && Objects.equals(images, that.images) && Objects.equals(artist, that.artist) && Objects.equals(format, that.format) && Objects.equals(resourceUrl, that.resourceUrl) && Objects.equals(title, that.title) && Objects.equals(catalogNumber, that.catalogNumber) && Objects.equals(stats, that.stats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(thumbnail, description, images, artist, format, resourceUrl, title, year, id, catalogNumber, stats);
    }
}
