package discojx.discogs.objects;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Company {

    private String name;
    private String catno;
    @JsonProperty("entity_type")
    private String entityType;
    @JsonProperty("entity_type_name")
    private String entityTypeName;
    private long id;
    @JsonProperty("resource_url")
    private String resource_url;

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

    public String getResource_url() {
        return resource_url;
    }

    public void setResource_url(String resource_url) {
        this.resource_url = resource_url;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", catno='" + catno + '\'' +
                ", entityType='" + entityType + '\'' +
                ", entityTypeName='" + entityTypeName + '\'' +
                ", id=" + id +
                ", resource_url=" + resource_url +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return id == company.id && Objects.equals(name, company.name) && Objects.equals(catno, company.catno) && Objects.equals(entityType, company.entityType) && Objects.equals(entityTypeName, company.entityTypeName) && Objects.equals(resource_url, company.resource_url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, catno, entityType, entityTypeName, id, resource_url);
    }
}
