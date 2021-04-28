package discojx.discogs.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class UserReleaseCollectionItems {

    public static class Release {

        public static class Short {
            @JsonProperty("instance_id")
            private long instanceId;
            @JsonProperty("resource_url")
            private URL resourceUrl;

            public long getInstanceId() {
                return instanceId;
            }

            public void setInstanceId(long instanceId) {
                this.instanceId = instanceId;
            }

            public URL getResourceUrl() {
                return resourceUrl;
            }

            public void setResourceUrl(URL resourceUrl) {
                this.resourceUrl = resourceUrl;
            }

            @Override
            public String toString() {
                return "Short{" +
                        "instanceId=" + instanceId +
                        ", resourceUrl=" + resourceUrl +
                        '}';
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Short aShort = (Short) o;
                return instanceId == aShort.instanceId && Objects.equals(resourceUrl, aShort.resourceUrl);
            }

            @Override
            public int hashCode() {
                return Objects.hash(instanceId, resourceUrl);
            }
        }

        public static class BasicInformation {
            private long id;
            @JsonProperty("master_id")
            private long masterId;
            @JsonProperty("resource_url")
            private URL resourceUrl;
            private String title;
            private int year;
            private List<Format> formats;
            private List<Label.Short> labels;
            private List<Artist.Short> artists;
            private URL thumb;
            @JsonProperty("cover_image")
            private URL coverImage;
            private List<String> genres;
            private List<String> styles;

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public long getMasterId() {
                return masterId;
            }

            public void setMasterId(long masterId) {
                this.masterId = masterId;
            }

            public URL getResourceUrl() {
                return resourceUrl;
            }

            public void setResourceUrl(URL resourceUrl) {
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

            public List<Format> getFormats() {
                return formats;
            }

            public void setFormats(List<Format> formats) {
                this.formats = formats;
            }

            public List<Label.Short> getLabels() {
                return labels;
            }

            public void setLabels(List<Label.Short> labels) {
                this.labels = labels;
            }

            public List<Artist.Short> getArtists() {
                return artists;
            }

            public void setArtists(List<Artist.Short> artists) {
                this.artists = artists;
            }

            public URL getThumb() {
                return thumb;
            }

            public void setThumb(URL thumb) {
                this.thumb = thumb;
            }

            public URL getCoverImage() {
                return coverImage;
            }

            public void setCoverImage(URL coverImage) {
                this.coverImage = coverImage;
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

            @Override
            public String toString() {
                return "BasicInformation{" +
                        "id=" + id +
                        ", masterId=" + masterId +
                        ", resourceUrl=" + resourceUrl +
                        ", title='" + title + '\'' +
                        ", year=" + year +
                        ", formats=" + formats +
                        ", labels=" + labels +
                        ", artists=" + artists +
                        ", thumb=" + thumb +
                        ", coverImage=" + coverImage +
                        ", genres=" + genres +
                        ", styles=" + styles +
                        '}';
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                BasicInformation that = (BasicInformation) o;
                return id == that.id && masterId == that.masterId && year == that.year && Objects.equals(resourceUrl, that.resourceUrl) && Objects.equals(title, that.title) && Objects.equals(formats, that.formats) && Objects.equals(labels, that.labels) && Objects.equals(artists, that.artists) && Objects.equals(thumb, that.thumb) && Objects.equals(coverImage, that.coverImage) && Objects.equals(genres, that.genres) && Objects.equals(styles, that.styles);
            }

            @Override
            public int hashCode() {
                return Objects.hash(id, masterId, resourceUrl, title, year, formats, labels, artists, thumb, coverImage, genres, styles);
            }
        }

        private long id;
        @JsonProperty("instance_id")
        private long instanceId;
        @JsonProperty("date_added")
        private Date dateAdded;
        private int rating;
        @JsonProperty("basic_information")
        private BasicInformation basicInformation;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public long getInstanceId() {
            return instanceId;
        }

        public void setInstanceId(long instanceId) {
            this.instanceId = instanceId;
        }

        public Date getDateAdded() {
            return dateAdded;
        }

        public void setDateAdded(Date dateAdded) {
            this.dateAdded = dateAdded;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        public BasicInformation getBasicInformation() {
            return basicInformation;
        }

        public void setBasicInformation(BasicInformation basicInformation) {
            this.basicInformation = basicInformation;
        }

        @Override
        public String toString() {
            return "Release{" +
                    "id=" + id +
                    ", instanceId=" + instanceId +
                    ", dateAdded=" + dateAdded +
                    ", rating=" + rating +
                    ", basicInformation=" + basicInformation +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Release release = (Release) o;
            return id == release.id && instanceId == release.instanceId && rating == release.rating && Objects.equals(dateAdded, release.dateAdded) && Objects.equals(basicInformation, release.basicInformation);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, instanceId, dateAdded, rating, basicInformation);
        }
    }

    private Pagination pagination;
    private List<Release> releases;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<Release> getReleases() {
        return releases;
    }

    public void setReleases(List<Release> releases) {
        this.releases = releases;
    }

    @Override
    public String toString() {
        return "ReleaseUserCollectionItem{" +
                "pagination=" + pagination +
                ", releases=" + releases +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserReleaseCollectionItems that = (UserReleaseCollectionItems) o;
        return Objects.equals(pagination, that.pagination) && Objects.equals(releases, that.releases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pagination, releases);
    }
}
