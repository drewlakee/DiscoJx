package discojx.discogs.objects.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class SearchResult extends AbstractTypedObject {

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

    protected long id;
    @JsonProperty("user_data")
    protected UserData userData;
    @JsonProperty("master_id")
    protected long masterId;
    @JsonProperty("master_url")
    protected String masterUrl;
    @JsonProperty("resource_url")
    protected String resourceUrl;
    @JsonProperty("cover_image")
    protected String coverImage;
    protected String uri;
    protected String thumb;
    protected String title;

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

    public String getMasterUrl() {
        return masterUrl;
    }

    public void setMasterUrl(String masterUrl) {
        this.masterUrl = masterUrl;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "AbstractSearchResult{" +
                "id=" + id +
                ", userData=" + userData +
                ", masterId=" + masterId +
                ", masterUrl='" + masterUrl + '\'' +
                ", resourceUrl='" + resourceUrl + '\'' +
                ", coverImage='" + coverImage + '\'' +
                ", uri='" + uri + '\'' +
                ", thumb='" + thumb + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SearchResult that = (SearchResult) o;
        return id == that.id && masterId == that.masterId && Objects.equals(userData, that.userData) && Objects.equals(masterUrl, that.masterUrl) && Objects.equals(resourceUrl, that.resourceUrl) && Objects.equals(coverImage, that.coverImage) && Objects.equals(uri, that.uri) && Objects.equals(thumb, that.thumb) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, userData, masterId, masterUrl, resourceUrl, coverImage, uri, thumb, title);
    }
}
