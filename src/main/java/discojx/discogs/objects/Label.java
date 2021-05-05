package discojx.discogs.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class Label {

    public static class Submissions {

        private String name;
        private long id;
        @JsonProperty("resource_url")
        private String resourceUrl;
        private String uri;
        @JsonProperty("releases_url")
        private String releasesUrl;
        private List<Image> images;
        @JsonProperty("contactinfo")
        private String contactInfo;
        private String profile;
        @JsonProperty("data_quality")
        private String dataQuality;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

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

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getReleasesUrl() {
            return releasesUrl;
        }

        public void setReleasesUrl(String releasesUrl) {
            this.releasesUrl = releasesUrl;
        }

        public List<Image> getImages() {
            return images;
        }

        public void setImages(List<Image> images) {
            this.images = images;
        }

        public String getContactInfo() {
            return contactInfo;
        }

        public void setContactInfo(String contactInfo) {
            this.contactInfo = contactInfo;
        }

        public String getProfile() {
            return profile;
        }

        public void setProfile(String profile) {
            this.profile = profile;
        }

        public String getDataQuality() {
            return dataQuality;
        }

        public void setDataQuality(String dataQuality) {
            this.dataQuality = dataQuality;
        }

        @Override
        public String toString() {
            return "Submissions{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    ", resourceUrl=" + resourceUrl +
                    ", uri=" + uri +
                    ", releasesUrl=" + releasesUrl +
                    ", images=" + images +
                    ", contactInfo='" + contactInfo + '\'' +
                    ", profile='" + profile + '\'' +
                    ", dataQuality='" + dataQuality + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Submissions that = (Submissions) o;
            return id == that.id && Objects.equals(name, that.name) && Objects.equals(resourceUrl, that.resourceUrl) && Objects.equals(uri, that.uri) && Objects.equals(releasesUrl, that.releasesUrl) && Objects.equals(images, that.images) && Objects.equals(contactInfo, that.contactInfo) && Objects.equals(profile, that.profile) && Objects.equals(dataQuality, that.dataQuality);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, id, resourceUrl, uri, releasesUrl, images, contactInfo, profile, dataQuality);
        }
    }

    public static class Short {

        private String name;
        private String catno;
        @JsonProperty("entity_type")
        private String entityType;
        @JsonProperty("entity_type_name")
        private String entityTypeName;
        private long id;
        @JsonProperty("resource_url")
        private String resourceUrl;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCatno() {
            return catno;
        }

        public void setCatno(String catno) {
            this.catno = catno;
        }

        public String getEntityType() {
            return entityType;
        }

        public void setEntityType(String entityType) {
            this.entityType = entityType;
        }

        public String getEntityTypeName() {
            return entityTypeName;
        }

        public void setEntityTypeName(String entityTypeName) {
            this.entityTypeName = entityTypeName;
        }

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

        @Override
        public String toString() {
            return "Short{" +
                    "name='" + name + '\'' +
                    ", catno='" + catno + '\'' +
                    ", entityType='" + entityType + '\'' +
                    ", entityTypeName='" + entityTypeName + '\'' +
                    ", id=" + id +
                    ", resourceUrl=" + resourceUrl +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Short aShort = (Short) o;
            return id == aShort.id && Objects.equals(name, aShort.name) && Objects.equals(catno, aShort.catno) && Objects.equals(entityType, aShort.entityType) && Objects.equals(entityTypeName, aShort.entityTypeName) && Objects.equals(resourceUrl, aShort.resourceUrl);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, catno, entityType, entityTypeName, id, resourceUrl);
        }
    }

    public static class SubLabel {

        private long id;
        private String name;
        @JsonProperty("resource_url")
        private String resourceUrl;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getResourceUrl() {
            return resourceUrl;
        }

        public void setResourceUrl(String resourceUrl) {
            this.resourceUrl = resourceUrl;
        }

        @Override
        public String toString() {
            return "SubLabel{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", resourceUrl=" + resourceUrl +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SubLabel subLabel = (SubLabel) o;
            return id == subLabel.id && Objects.equals(name, subLabel.name) && Objects.equals(resourceUrl, subLabel.resourceUrl);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, resourceUrl);
        }
    }

    private String name;
    private long id;
    @JsonProperty("resource_url")
    private String resourceUrl;
    private String uri;
    @JsonProperty("releases_url")
    private String releasesUrl;
    private List<Image> images;
    @JsonProperty("contact_info")
    private String contactInfo;
    private String profile;
    @JsonProperty("data_quality")
    private String dataQuality;
    private List<String> urls;
    @JsonProperty("sublabels")
    private List<SubLabel> subLabels;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getReleasesUrl() {
        return releasesUrl;
    }

    public void setReleasesUrl(String releasesUrl) {
        this.releasesUrl = releasesUrl;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDataQuality() {
        return dataQuality;
    }

    public void setDataQuality(String dataQuality) {
        this.dataQuality = dataQuality;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public List<SubLabel> getSubLabels() {
        return subLabels;
    }

    public void setSubLabels(List<SubLabel> subLabels) {
        this.subLabels = subLabels;
    }

    @Override
    public String toString() {
        return "Label{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", resourceUrl=" + resourceUrl +
                ", uri=" + uri +
                ", releasesUrl=" + releasesUrl +
                ", images=" + images +
                ", contactInfo='" + contactInfo + '\'' +
                ", profile='" + profile + '\'' +
                ", dataQuality='" + dataQuality + '\'' +
                ", urls=" + urls +
                ", subLabels=" + subLabels +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Label label = (Label) o;
        return id == label.id && Objects.equals(name, label.name) && Objects.equals(resourceUrl, label.resourceUrl) && Objects.equals(uri, label.uri) && Objects.equals(releasesUrl, label.releasesUrl) && Objects.equals(images, label.images) && Objects.equals(contactInfo, label.contactInfo) && Objects.equals(profile, label.profile) && Objects.equals(dataQuality, label.dataQuality) && Objects.equals(urls, label.urls) && Objects.equals(subLabels, label.subLabels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, resourceUrl, uri, releasesUrl, images, contactInfo, profile, dataQuality, urls, subLabels);
    }
}
