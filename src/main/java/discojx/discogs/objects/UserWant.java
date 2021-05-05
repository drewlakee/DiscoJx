package discojx.discogs.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class UserWant {

    public static class BasicInformation {
        private long id;
        @JsonProperty("master_id")
        private long masterId;
        @JsonProperty("resource_url")
        private String resourceUrl;
        private String title;
        private int year;
        private List<Format> formats;
        private List<Label.Short> labels;
        private List<Artist.Short> artists;
        private String thumb;
        @JsonProperty("cover_image")
        private String coverImage;
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
    @JsonProperty("resource_url")
    private String resourceUrl;
    private int rating;
    @JsonProperty("date_added")
    private Date dateAdded;
    @JsonProperty("basic_information")
    private BasicInformation basicInformation;
    private String notes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public BasicInformation getBasicInformation() {
        return basicInformation;
    }

    public void setBasicInformation(BasicInformation basicInformation) {
        this.basicInformation = basicInformation;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "UserWant{" +
                "id=" + id +
                ", resourceUrl=" + resourceUrl +
                ", rating=" + rating +
                ", dateAdded=" + dateAdded +
                ", basicInformation=" + basicInformation +
                ", notes='" + notes + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserWant userWant = (UserWant) o;
        return id == userWant.id && rating == userWant.rating && Objects.equals(resourceUrl, userWant.resourceUrl) && Objects.equals(dateAdded, userWant.dateAdded) && Objects.equals(basicInformation, userWant.basicInformation) && Objects.equals(notes, userWant.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, resourceUrl, rating, dateAdded, basicInformation, notes);
    }
}
