package discojx.discogs.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Objects;

public class Label {

    private String name;
    private String catno;
    @JsonProperty("entity_type")
    private String entityType;
    @JsonProperty("entity_type_name")
    private String entityTypeName;
    private long id;
    @JsonProperty("resource_url")
    private URL resourceUrl;
    private URI uri;
    @JsonProperty("releases_url")
    private URL releasesUrl;
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

    public URL getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(URL resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    public URL getReleasesUrl() {
        return releasesUrl;
    }

    public void setReleasesUrl(URL releasesUrl) {
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
        return "Label{" +
                "name='" + name + '\'' +
                ", catno='" + catno + '\'' +
                ", entityType='" + entityType + '\'' +
                ", entityTypeName='" + entityTypeName + '\'' +
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
        Label label = (Label) o;
        return id == label.id && Objects.equals(name, label.name) && Objects.equals(catno, label.catno) && Objects.equals(entityType, label.entityType) && Objects.equals(entityTypeName, label.entityTypeName) && Objects.equals(resourceUrl, label.resourceUrl) && Objects.equals(uri, label.uri) && Objects.equals(releasesUrl, label.releasesUrl) && Objects.equals(images, label.images) && Objects.equals(contactInfo, label.contactInfo) && Objects.equals(profile, label.profile) && Objects.equals(dataQuality, label.dataQuality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, catno, entityType, entityTypeName, id, resourceUrl, uri, releasesUrl, images, contactInfo, profile, dataQuality);
    }
}
