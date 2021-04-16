package discojx.discogs.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Label {

    private String name;
    private String catno;
    private String entityType;
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
        return "Label{" +
                "name='" + name + '\'' +
                ", catno='" + catno + '\'' +
                ", entityType='" + entityType + '\'' +
                ", entityTypeName='" + entityTypeName + '\'' +
                ", id=" + id +
                ", resourceUrl='" + resourceUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Label label = (Label) o;
        return id == label.id && Objects.equals(name, label.name) && Objects.equals(catno, label.catno) && Objects.equals(entityType, label.entityType) && Objects.equals(entityTypeName, label.entityTypeName) && Objects.equals(resourceUrl, label.resourceUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, catno, entityType, entityTypeName, id, resourceUrl);
    }
}
