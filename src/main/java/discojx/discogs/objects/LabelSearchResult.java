package discojx.discogs.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;
import java.net.URL;
import java.util.Objects;

public class LabelSearchResult extends AbstractTypedSearchResult {

    public static class UserData {
        @JsonProperty("in_wantlist")
        private boolean inWantList;
        @JsonProperty("int_collection")
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

    private long id;
    @JsonProperty("user_data")
    private UserData userData;
    @JsonProperty("master_id")
    private long masterId;
    @JsonProperty("master_url")
    private URL masterUrl;
    private URI uri;
    private String title;
    private URL thumb;
    @JsonProperty("cover_image")
    private URL coverImage;
    @JsonProperty("resource_url")
    private URL resourceUrl;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public URL getMasterUrl() {
        return masterUrl;
    }

    public void setMasterUrl(URL masterUrl) {
        this.masterUrl = masterUrl;
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public URL getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(URL resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    @Override
    public String toString() {
        return "LabelSearchResult{" +
                "id=" + id +
                ", userData=" + userData +
                ", masterId=" + masterId +
                ", masterUrl=" + masterUrl +
                ", uri=" + uri +
                ", title='" + title + '\'' +
                ", thumb=" + thumb +
                ", coverImage=" + coverImage +
                ", resourceUrl=" + resourceUrl +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LabelSearchResult that = (LabelSearchResult) o;
        return id == that.id && masterId == that.masterId && Objects.equals(userData, that.userData) && Objects.equals(masterUrl, that.masterUrl) && Objects.equals(uri, that.uri) && Objects.equals(title, that.title) && Objects.equals(thumb, that.thumb) && Objects.equals(coverImage, that.coverImage) && Objects.equals(resourceUrl, that.resourceUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, userData, masterId, masterUrl, uri, title, thumb, coverImage, resourceUrl);
    }
}
